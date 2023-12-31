package com.airrowing.system.service.impl;

import com.airrowing.system.pojo.ClubAttendance;
import com.airrowing.system.pojo.TolAttendanceTable;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.airrowing.system.pojo.ClubTraining;
import com.airrowing.system.service.ClubTrainingService;
import com.airrowing.system.mapper.ClubTrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Austin
* @description 针对表【club_training】的数据库操作Service实现
* @createDate 2023-12-14 14:57:01
*/
@Service
public class ClubTrainingServiceImpl extends ServiceImpl<ClubTrainingMapper, ClubTraining>
    implements ClubTrainingService{
    ClubTrainingMapper clubTrainingMapper;
    @Autowired
    public ClubTrainingServiceImpl(ClubTrainingMapper clubTrainingMapper){ this.clubTrainingMapper = clubTrainingMapper;}
    @Override
    public List<ClubTraining> selectAll() {
        return clubTrainingMapper.selectAll();
    }

    @Override
    public int[] getMonthlyTrainingCount(int year) {
        List<ClubTraining> records = clubTrainingMapper.selectAll();
        int[] monthlyCount = new int[12];

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式与你的字符串格式匹配

        for (ClubTraining record : records) {
            try {
                Date date = dateFormat.parse(record.getClubTrainingTime());
                cal.setTime(date);

                if (cal.get(Calendar.YEAR) == year) {
                    int month = cal.get(Calendar.MONTH);
                    monthlyCount[month]++;
                }
            } catch (ParseException e) {
                // 处理日期解析异常
                e.printStackTrace();
            }
        }

        return monthlyCount;
    }

    @Override
    public int[] getDailyTrainingCount(int year, int month) {
        List<ClubTraining> records = clubTrainingMapper.selectAll();
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[] dailyCount = new int[daysInMonth];

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式与你的字符串格式匹配

        for (ClubTraining record : records) {
            try {
                Date date = dateFormat.parse(record.getClubTrainingTime());
                cal.setTime(date);

                if (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month - 1) {
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    dailyCount[day - 1]++;
                }
            } catch (ParseException e) {
                // 处理日期解析异常
                e.printStackTrace();
            }
        }

        return dailyCount;
    }

    @Override
    public List<ClubAttendance> getAttendance() {
        return clubTrainingMapper.getMsg();
    }

    @Override
    public List<ClubAttendance> getSelectedUserMsg(int id) {
        return clubTrainingMapper.getSelectedUserMsg(id);
    }

    @Override
    public List<TolAttendanceTable> getTolAttendance() {
        return clubTrainingMapper.getTolAttendance();
    }

    @Override
    public List<TolAttendanceTable> getTolAttendanceByName(String strName) {
        List<TolAttendanceTable> record = clubTrainingMapper.getTolAttendance();

        // 使用 stream 和 filter 方法来筛选出名字中包含给定字符串的记录
        List<TolAttendanceTable> filteredRecord = record.stream()
                .filter(r -> r.getName().contains(strName))
                .collect(Collectors.toList());

        return filteredRecord;
    }

    @Override
    public int getTolTrainNum(int year) {
        List<ClubTraining> records = clubTrainingMapper.selectAll();

        int count = 0;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式与你的字符串格式匹配

        for (ClubTraining record : records) {
            try {
                Date clubTrainingTime = dateFormat.parse(record.getClubTrainingTime());
                cal.setTime(clubTrainingTime);

                // 检查年份是否匹配
                if (cal.get(Calendar.YEAR) == year) {
                    count++;
                }
            } catch (ParseException e) {
                // 处理日期解析异常
                e.printStackTrace();
            }
        }

        return count;
    }



}




