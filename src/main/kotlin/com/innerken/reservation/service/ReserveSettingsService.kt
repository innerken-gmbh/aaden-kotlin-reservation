package com.innerken.reservation.service

import com.baomidou.mybatisplus.extension.service.IService
import com.innerken.reservation.dto.requestDTO.ReserveSettingsRequestDTO
import com.innerken.reservation.model.ReserveSettings

interface ReserveSettingsService : IService<ReserveSettings> {
    fun updateReserveSettings(reserveSettingsRequestDTO: ReserveSettingsRequestDTO): Int
}