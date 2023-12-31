package com.airrowing.system.pojo;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.util.Date;

//这是一个出勤表格
@Data
public class ClubAttendance {

    private Integer userId;
    private String name;
    private Integer trainingId;
    private String trainingName;
    private boolean isPresent;
    private Date Attendance;

}
