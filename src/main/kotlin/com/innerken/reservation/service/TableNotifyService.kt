package com.innerken.reservation.service

import com.baomidou.mybatisplus.extension.service.IService
import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.model.TableNotify
import java.time.DayOfWeek

interface TableNotifyService : IService<TableNotify>{

    fun getTableType(person : Int): Int

    fun getTableTime(id: String):List<String>

}