package com.airrowing.system.mapper;

import com.airrowing.system.pojo.TrainingRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【training_record】的数据库操作Mapper
 * @createDate 2023-12-18 13:05:25
 * @Entity com.airrowing.system.pojo.TrainingRecord
 */
public interface TrainingRecordMapper extends BaseMapper<TrainingRecord> {


    @Select("select * from training_record")
    List<TrainingRecord> selectAll();
}




