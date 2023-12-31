package com.airrowing.system.controller;

import com.airrowing.system.dto.ApiDataResponse;
import com.airrowing.system.pojo.ClubAttendance;
import com.airrowing.system.pojo.ClubTraining;
import com.airrowing.system.pojo.Test;
import com.airrowing.system.pojo.TolAttendanceTable;
import com.airrowing.system.service.ClubTrainingService;
// import com.airrowing.system.service.TestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "ClubTraining",
        description = "俱乐部训练"
)
@RestController
@CrossOrigin // 跨域
@RequestMapping("/api/clubtraining")
public class ClubTrainingController {
    ClubTrainingService clubTrainingService;
    @Autowired
    public ClubTrainingController(ClubTrainingService clubTrainingService){this.clubTrainingService = clubTrainingService;}

    @GetMapping("/list")
    public ApiDataResponse<List<ClubTraining>> getClubTraining(){return ApiDataResponse.success(clubTrainingService.selectAll());}

    //    折线图相关呈现
    @GetMapping("/getMonthlyTrainingCount")
    public ApiDataResponse<int[]> getMonthlyTrainingCount(@RequestParam int year) {
        int[] monthlyCount = clubTrainingService.getMonthlyTrainingCount(year);
        return ApiDataResponse.success(monthlyCount);
    }

    @GetMapping("/getDailyTrainingCount")
    public ApiDataResponse<int[]> getDailyTrainingCount(@RequestParam int year, @RequestParam int month) {
        int[] dailyCount = clubTrainingService.getDailyTrainingCount(year, month);
        return ApiDataResponse.success(dailyCount);
    }

    @GetMapping("/getTolTrainNum")
    public ApiDataResponse<Integer> getTolTrainNum(@RequestParam int year) {
        int num = clubTrainingService.getTolTrainNum(year);
        return ApiDataResponse.success(num);
    }

    @GetMapping("/getSpecialAttendance")
    public ApiDataResponse<List<ClubAttendance>> getSpecialAttendance(@RequestParam int userId) {
        return ApiDataResponse.success(clubTrainingService.getSelectedUserMsg(userId));
    }

    @GetMapping("/getTolAttendanceTable")
    public ApiDataResponse<List<TolAttendanceTable>> getTolAttendanceTable() {
        return ApiDataResponse.success(clubTrainingService.getTolAttendance());
    }


    @GetMapping("/getTolAttendanceTableByname")
    public ApiDataResponse<List<TolAttendanceTable>> getTolAttendanceTableByname(@RequestParam String name) {
        return ApiDataResponse.success(clubTrainingService.getTolAttendanceByName(name));
    }


}
