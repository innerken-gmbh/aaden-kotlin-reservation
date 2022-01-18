package com.innerken.reservation.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.pool2.BaseObject;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("reserve_settings")
public class ReserveSettings extends BaseObject {
    private Integer id;

    private Integer gap;

    private String weeklySettings;
}
