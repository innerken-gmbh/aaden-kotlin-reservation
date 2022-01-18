package com.innerken.reservation.dto.requestDTO;

import cn.hutool.core.date.DateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("预定管理")
public class ReservationRequestDTO{
    private Integer id;
    private Integer tableId;
    private String fromDateTime;
    private String toDateTime;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private String company;
    private String note;
    private Integer personCount;
    private Integer childCount;
    private Integer useStroller;
}
