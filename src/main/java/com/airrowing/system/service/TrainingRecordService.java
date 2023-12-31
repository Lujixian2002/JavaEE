package com.airrowing.system.service;

import com.airrowing.system.pojo.TrainingRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【training_record】的数据库操作Service
 * @createDate 2023-12-18 13:05:25
 */
public interface TrainingRecordService extends IService<TrainingRecord> {

    List<TrainingRecord> selectAll();

    Float getTolAttendancePer();
}
