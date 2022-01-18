package com.innerken.reservation.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.innerken.reservation.model.Reservation

interface ReservationMapper : BaseMapper<Reservation>{
  fun getReservation():MutableList<Reservation>

  fun getCanceledTime(id :  Int):Int

}