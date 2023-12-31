package com.airrowing.system.service;

import com.airrowing.system.pojo.Login;
import com.airrowing.system.pojo.Test;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Lik
* @description 针对表【login】的数据库操作Service
* @createDate 2023-12-18 15:43:14
*/
public interface LoginService extends IService<Login> {
    List<Login> selectUser(String account);

}
