package com.innerken.reservation.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class table {
    public static final int SEATCOUNT4= 4;

    public static final int SEATCOUNT6= 6;

    public static  String tableTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MINUTE, 15);
        return dateFormat.format(startCalendar.getTime()).toString();
    }

    public static Integer  dayOfWeek(){
        Integer[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar startCalendar = Calendar.getInstance();
        return weekDays[startCalendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static List<String> baseTimeSlot(String startTime, String endTime, int rate ) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(dateFormat.parse(startTime));
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(dateFormat.parse(endTime));
        if(endCalendar.compareTo(startCalendar)<0){
            endCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        List<String> retList = new ArrayList<>();
        retList.add(startTime);
        while (true) {
            startCalendar.add(Calendar.MINUTE, rate);
            if (startCalendar.compareTo(endCalendar) >= 0)
                break;
            retList.add(dateFormat.format(startCalendar.getTime()));
        }
        retList.add(endTime);
        return retList;
    }}
