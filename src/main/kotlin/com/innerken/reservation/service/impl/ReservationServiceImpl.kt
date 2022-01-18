package com.innerken.reservation.service.impl

import com.baomidou.mybatisplus.extension.api.R
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.innerken.reservation.dto.requestDTO.ReservationRequestDTO
import com.innerken.reservation.dto.requestDTO.TableRequestDTO
import com.innerken.reservation.mapper.ReservationMapper
import com.innerken.reservation.mapper.TableNotifyMapper
import com.innerken.reservation.model.Reservation
import com.innerken.reservation.model.TableNotify
import com.innerken.reservation.service.ReservationService
import com.innerken.reservation.utils.HttpRequest
import com.netflix.ribbon.proxy.annotation.Http
import org.apache.poi.ss.formula.functions.T
import org.springframework.beans.BeanUtils
import org.springframework.boot.actuate.health.HttpCodeStatusMapper
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class ReservationServiceImpl :
        ServiceImpl<ReservationMapper, Reservation>(),
        ReservationService {
    @Resource
    lateinit var reservationMapper: ReservationMapper
    lateinit var reservationService: ReservationService
    lateinit var  javaMailSender: JavaMailSender
    lateinit var  tableNotifyMapper: TableNotifyMapper


     override fun addReservation(reservationRequestDTO: ReservationRequestDTO): Int {
        val reservation = Reservation()
        BeanUtils.copyProperties(reservationRequestDTO, reservation)
        reservationService.sendEmail{
             setText("Book successfully!")
         }
        return reservationMapper.insert(reservation)
    }

    override fun getReservation(): MutableList<Reservation> {
       return reservationMapper.getReservation()
    }
    override fun requestReplayReservation(tableRequestDTO: TableRequestDTO, notifyType : String): Int{
        val tableNotify = TableNotify()
        BeanUtils.copyProperties(tableRequestDTO, tableNotify)
        when (notifyType) {
            "added" -> {
                tableNotifyMapper.insert(tableNotify)
            }
            "removed" -> {
                tableNotifyMapper.deleteById(tableRequestDTO.id)
            }
            "changed" -> {
                tableNotifyMapper.updateById(tableNotify)
            }
        }
        return 200}

    override fun delReservation(reservationRequestDTO: ReservationRequestDTO): Int {
        return reservationMapper.getCanceledTime(reservationRequestDTO.id)
     }

    @Async
    override fun sendEmail(helperBlock: MimeMessageHelper.() -> Unit) {
        val message = javaMailSender.createMimeMessage()

        val helper = MimeMessageHelper(
            message,
            MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
            Charsets.UTF_8.name()
        )
        helper.helperBlock()
        javaMailSender.send(message)
    }
}
