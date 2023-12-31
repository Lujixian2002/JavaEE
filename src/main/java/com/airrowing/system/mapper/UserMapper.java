package com.airrowing.system.mapper;

import com.airrowing.system.pojo.UserManList;
import com.airrowing.system.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 28061
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-12-13 16:21:48
* @Entity com.airrowing.system.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    // @Select("SELECT user_id,user_nickname,user_real_name,user_gender," +
    //         "user_height,user_weight,user_phone_number" +
    //         " FROM user " +
    //         "WHERE " +
    //         "   (#{nickname} IS NULL OR user_nickname = #{nickname}) " +
    //         "   AND (#{name} IS NULL OR user_real_name = #{name}) " +
    //         "   AND (#{gender} =-1 OR user_gender = #{gender}) " +
    //         "   AND (#{maxHeight} IS NULL OR user_height <= #{maxHeight}) " +
    //         "   AND (#{minHeight} IS NULL OR user_height >= #{minHeight}) " +
    //         "   AND (#{maxWeight} IS NULL OR user_weight <= #{maxWeight}) " +
    //         "   AND (#{minWeight} IS NULL OR user_weight >= #{minWeight}) " +
    //         "   AND (#{phoneNumber} IS NULL OR user_phone_number = #{phoneNumber})" +
    //         "   AND apply_club_status = 0")
    // List<UserManList> selectByConditions(@Param("nickname") String nickname,
    //                                      @Param("name") String name,
    //                                      @Param("gender") int gender,
    //                                      @Param("maxHeight") int maxHeight,
    //                                      @Param("minHeight") int minHeight,
    //                                      @Param("maxWeight") int maxWeight,
    //                                      @Param("minWeight") int minWeight,
    //                                      @Param("phoneNumber") String phoneNumber);
    @Select("SELECT user_id,user_nickname,user_real_name,user_gender," +
            "user_height,user_weight,user_phone_number " +
            "FROM user " +
            "WHERE apply_club_status = 0")
    List<UserManList> selectAllMembers();

    @Delete("DELETE FROM user WHERE user_id = #{userId}")
    Boolean deleteByUserId(@Param("userId") int userId);

    @Select("SELECT user_id,user_nickname,user_real_name,user_gender," +
            "user_height,user_weight,user_phone_number " +
            "FROM user " +
            "WHERE apply_club_status = 1")
    List<UserManList> selectAllApplied();


    // @Update("UPDATE user " +
    //         "SET apply_club_status = 0, " +
    //         "user_club = null "+
    //         "WHERE #{userId} = user_id;")
    @Delete("DELETE FROM user WHERE user_id = #{userId}")
    void refuseApplication(int userId);

    @Update("UPDATE user " +
            "SET apply_club_status = 0 " +
            "WHERE #{userId} = user_id;")
    void commitApplication(int userId);
}