package com.innerken.reservation.service.impl

import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.mapper.ReservationMapper
import com.innerken.reservation.mapper.TableNotifyMapper
import com.innerken.reservation.model.Reservation
import com.innerken.reservation.model.ReserveSettings
import com.innerken.reservation.model.TableNotify
import com.innerken.reservation.service.TableNotifyService
import com.innerken.reservation.utils.HttpRequest
import com.innerken.reservation.utils.table
import org.springframework.stereotype.Service
import java.time.DayOfWeek
import java.time.LocalTime
import javax.annotation.Resource

@Service
class TableNotifyServiceImpl:
        ServiceImpl<TableNotifyMapper, TableNotify>(),
        TableNotifyService{
        @Resource
        lateinit var reservationMapper: ReservationMapper
        lateinit var tableNotifyMapper: TableNotifyMapper
    override fun getTableType(person : Int) : Int{
        return if (person <= table.SEATCOUNT4){
            table.SEATCOUNT4
        }else{
            table.SEATCOUNT4 and table.SEATCOUNT6
        }}

    override fun getTableTime(id:String): List<String> {
        HttpRequest.doOperationAndWaitForResult("http://ik9002.ngrok.aaden.io", id)
        HttpRequest.doOperationAndWaitForResult("http://ik9002.ngrok.aaden.io", table.dayOfWeek().toString())
        val settings = HttpRequest.sendPost("http://ik9002.ngrok.aaden.io", table.dayOfWeek().toString())
        val tableProp = HttpRequest.sendPost("http://ik9002.ngrok.aaden.io", id)
        val tableNotify = TableNotify()
        val reserveSettings = ReserveSettings()
        tableNotify.activeOrderCreatedAt = tableProp.getString("activeOrderCreatedAt")
        tableNotify.activeOrderEstimateDingingTo = tableProp.getString("activeOrderEstimateDingingTo")
        reserveSettings.gap = settings.getIntValue("gap")
        reserveSettings.weeklySettings = settings.getString("weeklySettings")
        val weeklySettings = JSON.parseObject(reserveSettings.weeklySettings)
        val openingTimeSpan = JSON.parseObject(weeklySettings.getString("openingTimeSpan"))
        val from = openingTimeSpan.getString("from")
        val to = openingTimeSpan.getString("to")
        val baseTimeSlot = table.baseTimeSlot(from, to, reserveSettings.gap)
        var result: List<String> = ArrayList()
        val reservation=Reservation()
        val tableId = tableNotifyMapper.selectById(id).id
        reservation.toDateTime = reservationMapper.selectById(tableId).toDateTime
        reservation.fromDateTime = reservationMapper.selectById(tableId).fromDateTime
        for (value in baseTimeSlot){
            if (value >= table.tableTime() ||
                value >= tableNotify.activeOrderEstimateDingingTo ||
                value != reservation.fromDateTime||
                value != reservation.toDateTime ){
                 result = result + value
            }}
        return result
    }}
