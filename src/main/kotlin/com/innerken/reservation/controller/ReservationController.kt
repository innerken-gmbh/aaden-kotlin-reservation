package com.innerken.reservation.controller

import com.innerken.reservation.dto.requestDTO.ReservationRequestDTO
import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.service.ReservationService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@Api(value = "预定-前端控制器", tags = ["预定-前端控制器"])
@RestController
@RequestMapping("/reservation")
class ReservationController {
    @Resource
    lateinit var reservationService: ReservationService
    @ApiOperation(value = "添加预定", notes = "添加预定")
    @PostMapping("/add")
    fun addReservation(
        @RequestBody  reservationRequestDTO: ReservationRequestDTO,
    ):Any
    {
        return  reservationService.addReservation(reservationRequestDTO)
    }

    @ApiOperation(value = "预定列表", notes = "预定列表")
    @PostMapping("/list")
    fun getReservation():Any{
        return reservationService.getReservation()
    }
    @ApiOperation(value = "replay", notes = "replay")
    @PostMapping("/replay")
    fun getReplayTable(@RequestBody tableRequestDTO: TableRequestDTO, notifyType : String):Any{
        return reservationService.requestReplayReservation(tableRequestDTO, notifyType)
    }

    @ApiOperation(value = "删除预定", notes = "删除预定")
    @PostMapping("/delete")
    fun delReservation(@RequestBody reservationRequestDTO: ReservationRequestDTO): Any
    {return reservationService.delReservation(reservationRequestDTO)}
}
