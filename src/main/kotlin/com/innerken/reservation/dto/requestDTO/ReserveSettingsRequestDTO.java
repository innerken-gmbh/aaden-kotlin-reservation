package com.innerken.reservation.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("预定设定管理")
public class ReserveSettingsRequestDTO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "槽位")
    private Integer gap;

    @ApiModelProperty(value = "一周设置")
    private String weeklySettings;
}
