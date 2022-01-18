package com.innerken.reservation.model;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.pool2.BaseObject;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("reservation")
public class Reservation extends BaseObject {
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
