package com.airrowing.system.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TolAttendanceTable {
    private Integer userId;
    private String name;

    private Integer trainingNum;
    private Date lastAttendance;

}
