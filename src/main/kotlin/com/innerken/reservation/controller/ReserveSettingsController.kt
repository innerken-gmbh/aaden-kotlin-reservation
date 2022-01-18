package com.innerken.reservation.controller

import com.innerken.reservation.dto.requestDTO.ReserveSettingsRequestDTO
import com.innerken.reservation.service.ReserveSettingsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@Api(value = "预定设置-前端控制器", tags = ["预定设置-前端控制器"])
@RestController
@RequestMapping("/reserveSettings")
class ReserveSettingsController {
    @Resource
    lateinit var reserveSettingsService: ReserveSettingsService

    @ApiOperation(value = "编辑预定设置", notes = "编辑预定设置")
    @PostMapping("/update")
    fun updateOpeningTime(
        @RequestBody reserveSettingsRequestDTO: ReserveSettingsRequestDTO,
    ): Any
    {return reserveSettingsService.updateReserveSettings(reserveSettingsRequestDTO)}

}
