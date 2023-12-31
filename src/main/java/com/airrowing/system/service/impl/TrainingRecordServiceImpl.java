package com.airrowing.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.airrowing.system.pojo.TrainingRecord;
import com.airrowing.system.service.TrainingRecordService;
import com.airrowing.system.mapper.TrainingRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【training_record】的数据库操作Service实现
 * @createDate 2023-12-18 13:05:25
 */
@Service
public class TrainingRecordServiceImpl extends ServiceImpl<TrainingRecordMapper, TrainingRecord>
        implements TrainingRecordService{

    TrainingRecordMapper trainingRecordMapper;

    @Autowired
    public TrainingRecordServiceImpl(TrainingRecordMapper trainingRecordMapper){
        this.trainingRecordMapper = trainingRecordMapper;
    }

    @Override
    public List<TrainingRecord> selectAll() {
        return trainingRecordMapper.selectAll();
    }

    @Override
    public Float getTolAttendancePer() {
        List<TrainingRecord> records = trainingRecordMapper.selectAll();
        int total = records.size();
        int presentCount = 0;

        for (TrainingRecord record : records) {
            if (record.getIsPresent() == 1) {
                presentCount++;
            }
        }

        return (float) presentCount / total * 100;
    }

}




