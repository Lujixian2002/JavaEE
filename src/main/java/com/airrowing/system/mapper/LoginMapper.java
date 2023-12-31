package com.airrowing.system.mapper;

import com.airrowing.system.pojo.Login;
import com.airrowing.system.pojo.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Lik
* @description 针对表【login】的数据库操作Mapper
* @createDate 2023-12-18 15:43:14
* @Entity com.airrowing.system.pojo.Login
*/
public interface LoginMapper extends BaseMapper<Login> {

    @Select("select * from login t where t.account = #{account}")
    List<Login> selectUser(@Param("account") String account);
}




