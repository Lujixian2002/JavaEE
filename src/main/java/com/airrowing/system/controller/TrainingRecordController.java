package com.airrowing.system.controller;

import com.airrowing.system.dto.ApiDataResponse;
import com.airrowing.system.pojo.ClubTraining;
import com.airrowing.system.pojo.TrainingRecord;
import com.airrowing.system.service.ClubTrainingService;
import com.airrowing.system.service.TrainingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // 跨域
@RequestMapping("/api/trainingRecord")
public class TrainingRecordController {
    TrainingRecordService trainingRecordService;
    @Autowired
    public TrainingRecordController(TrainingRecordService trainingRecordService){this.trainingRecordService = trainingRecordService;}

    @GetMapping("/list")
    public ApiDataResponse<List<TrainingRecord>> getTrainingRecord(){return ApiDataResponse.success(trainingRecordService.selectAll());}

    @GetMapping("/getAttendancePer")
    public ApiDataResponse<Float> getAttendancePer() {
        return ApiDataResponse.success(trainingRecordService.getTolAttendancePer());
    }

}
