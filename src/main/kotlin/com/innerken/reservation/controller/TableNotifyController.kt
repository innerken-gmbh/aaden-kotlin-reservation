package com.innerken.reservation.controller

import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.service.TableNotifyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@Api(value = "桌子-前端控制器", tags = ["桌子-前端控制器"])
@RestController
@RequestMapping("/table")
class TableNotifyController {
    @Resource
    lateinit var tableNotifyService: TableNotifyService

    @ApiOperation(value = "桌子类型", notes = "桌子类型")
    @PostMapping("/getTableType/{person}")
    fun getTableType(
        @PathVariable person :Int
    ):Any
    {return tableNotifyService.getTableType(person)}

    @ApiOperation(value = "桌子时间", notes = "桌子时间")
    @PostMapping("/timeList/{id}")
    fun getTableTime(
        @PathVariable id:String
    ): Any
    {
        return tableNotifyService.getTableTime(id)
    }
    }