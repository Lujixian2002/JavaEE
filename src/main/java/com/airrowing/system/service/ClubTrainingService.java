package com.airrowing.system.service;

import com.airrowing.system.pojo.ClubAttendance;
import com.airrowing.system.pojo.ClubTraining;
import com.airrowing.system.pojo.TolAttendanceTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Austin
* @description 针对表【club_training】的数据库操作Service
* @createDate 2023-12-14 14:57:01
*/
public interface ClubTrainingService extends IService<ClubTraining> {
    List<ClubTraining> selectAll();

    int[] getMonthlyTrainingCount(int year);

    int[] getDailyTrainingCount(int year,int month);

    List<ClubAttendance> getAttendance();

    List<ClubAttendance> getSelectedUserMsg(int id);

    List<TolAttendanceTable> getTolAttendance();
    List<TolAttendanceTable> getTolAttendanceByName(String str);

    int getTolTrainNum(int year);

}
