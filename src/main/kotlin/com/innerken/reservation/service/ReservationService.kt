package com.innerken.reservation.service

import com.baomidou.mybatisplus.extension.service.IService
import com.innerken.reservation.dto.requestDTO.ReservationRequestDTO
import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.model.Reservation
import org.springframework.mail.javamail.MimeMessageHelper

interface ReservationService : IService<Reservation>{

    fun addReservation(reservationRequestDTO: ReservationRequestDTO): Int

    fun getReservation(): MutableList<Reservation>

    fun requestReplayReservation(tableRequestDTO: TableRequestDTO, notifyType : String): Int

    fun sendEmail(helperBlock: MimeMessageHelper.() -> Unit)

    fun delReservation(reservationRequestDTO: ReservationRequestDTO): Int
}