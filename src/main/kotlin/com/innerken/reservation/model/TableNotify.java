package com.innerken.reservation.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.awt.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)


public class TableNotify {
    private Integer id;
    private Integer seatCount;
    private String activeOrderEstimateDingingTo;
    private String activeOrderCreatedAt;
    private List futureReservations;
}
