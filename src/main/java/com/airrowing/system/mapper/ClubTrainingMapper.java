package com.airrowing.system.mapper;

import com.airrowing.system.pojo.ClubAttendance;
import com.airrowing.system.pojo.ClubTraining;
import com.airrowing.system.pojo.TolAttendanceTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Austin
* @description 针对表【club_training】的数据库操作Mapper
* @createDate 2023-12-14 14:57:01
* @Entity com.airrowing.system.pojo.ClubTraining
*/
public interface ClubTrainingMapper extends BaseMapper<ClubTraining> {
    @Select("select * from club_training")
    List<ClubTraining> selectAll();


    @Select("SELECT u.user_id AS user_id, t.club_training_id AS training_id, u.user_real_name AS name, t.is_Present AS isPresent,c.club_training_name AS trainingName, c.club_training_time AS Attendance\n" +
            "FROM user AS u\n" +
            "LEFT JOIN training_record AS t ON u.user_id = t.user_id\n" +
            "LEFT JOIN club_training AS c ON t.club_training_id = c.club_training_id\n"
    )
    List<ClubAttendance> getMsg();

    @Select("SELECT u.user_id AS user_id, t.club_training_id AS training_id, u.user_real_name AS name, t.is_Present AS isPresent, c.club_training_name AS trainingName, c.club_training_time AS Attendance\n" +
            "FROM user AS u\n" +
            "LEFT JOIN training_record AS t ON u.user_id = t.user_id\n" +
            "LEFT JOIN club_training AS c ON t.club_training_id = c.club_training_id\n" +
            "WHERE u.user_id = #{user_id}\n"
    )
    List<ClubAttendance> getSelectedUserMsg(@Param("user_id") int user_id);

    @Select("SELECT \n" +
            "    u.user_id AS user_id, \n" +
            "    u.user_real_name AS name, \n" +
            "    SUM(CASE WHEN t.is_Present THEN 1 ELSE 0 END) AS trainingNum, \n" +
            "    MAX(CASE WHEN t.is_Present THEN c.club_training_time END) AS last_attendance\n" +
            "FROM \n" +
            "    user AS u\n" +
            "LEFT JOIN \n" +
            "    training_record AS t ON u.user_id = t.user_id\n" +
            "LEFT JOIN \n" +
            "    club_training AS c ON t.club_training_id = c.club_training_id\n" +
            "GROUP BY \n" +
            "    u.user_id, u.user_real_name\n")
    List<TolAttendanceTable> getTolAttendance();


}




