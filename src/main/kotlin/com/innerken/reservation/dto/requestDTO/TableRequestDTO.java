package com.innerken.reservation.dto.requestDTO;

import com.itextpdf.text.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel("桌子管理")
public class TableRequestDTO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "人数")
    private Integer seatCount;
    @ApiModelProperty(value = "上个活跃订单时间")
    private String activeOrderCreatedAt;

    @ApiModelProperty(value = "活跃订单 预计用餐时间")
    private String activeOrderEstimateDingingTo;
    private List futureReservations;
}