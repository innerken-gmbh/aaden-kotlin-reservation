package com.innerken.reservation.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.innerken.reservation.dto.requestDTO.ReserveSettingsRequestDTO
import com.innerken.reservation.mapper.ReserveSettingsMapper
import com.innerken.reservation.model.Reservation
import com.innerken.reservation.model.ReserveSettings
import com.innerken.reservation.service.ReserveSettingsService
import com.innerken.reservation.utils.HttpRequest
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class ReserveSettingsServiceImpl :
        ServiceImpl<ReserveSettingsMapper, ReserveSettings>(),
        ReserveSettingsService{
        @Resource
        lateinit var reserveSettingsMapper: ReserveSettingsMapper


    override fun updateReserveSettings(reserveSettingsRequestDTO: ReserveSettingsRequestDTO): Int {
        val reserveSettings = ReserveSettings()
        BeanUtils.copyProperties(reserveSettingsRequestDTO, reserveSettings)
        return reserveSettingsMapper.updateById(reserveSettings)
    }}
