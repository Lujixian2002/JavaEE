package com.airrowing.system.service.impl;

import com.airrowing.system.pojo.Test;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.airrowing.system.pojo.Login;
import com.airrowing.system.service.LoginService;
import com.airrowing.system.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Lik
* @description 针对表【login】的数据库操作Service实现
* @createDate 2023-12-18 15:43:14
*/
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login>
    implements LoginService{

    LoginMapper loginMapper;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public List<Login> selectUser(String account){
        return loginMapper.selectUser(account);
    }

}




