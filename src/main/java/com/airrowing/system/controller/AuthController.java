package com.airrowing.system.controller;

import com.airrowing.system.dto.ApiDataResponse;
import com.airrowing.system.pojo.*;
import com.airrowing.system.service.LoginService;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import com.auth0.jwt.JWT;

@Tag(
        name = "auth",
        description = "login"
)
@RestController
@CrossOrigin // 跨域
@RequestMapping("/auth")
public class AuthController {
//    TestService testService;
    LoginService loginService;

    @Autowired
    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }

//    @GetMapping("/login")
//    public ApiDataResponse<Boolean> loging(String account, String password) {
//        System.out.println("login is called");
//        List<Test> testList = this.testService.selectUser(account);
//        if(testList.get(0).getPassword().equals(password))
//            return ApiDataResponse.success(true);
//        else
//            return ApiDataResponse.fail(4001, "密码错误");
//
//
//    }

//    @PostMapping("/login")
//    public ApiDataResponse<String> loging(@RequestBody ReceiveLogin receiveLogin) {
//        System.out.println("login is called");
//        List<Test> testList = this.testService.selectUser(receiveLogin.getUsername());
//
//        if(testList.get(0).getPassword().equals(receiveLogin.getPassword())) {
//            String token;
//            // 创建一个过期时间为两个小时后的 Date 对象
//            Date expirationTime = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000);
//
//            token = JWT.create().withAudience(receiveLogin.getUsername())// 将 user id 保存到 token 里面,作为载荷
//                    .withExpiresAt(expirationTime)// 2小时后token过期
//                    .sign(Algorithm.HMAC256(receiveLogin.getPassword()));// 以 password 作为 token 的密钥
//
//            return ApiDataResponse.success(token);
//        }
//        else
//            return ApiDataResponse.fail(4001, "密码错误");
//    }

    @PostMapping("/login")
    public ApiDataResponse<Login> loging(@RequestBody ReceiveLogin receiveLogin) {

        System.out.println("login is called");
        List<Login> testList = this.loginService.selectUser(receiveLogin.getUsername());

        if(!testList.isEmpty() && testList.get(0).getPassword().equals(receiveLogin.getPassword())) {


//            authLoginResponse.setId("1");
//            authLoginResponse.setName("John Doe");
//            authLoginResponse.setUsername("johndoe");
//            authLoginResponse.setAvatar("https://example.com/avatar.png");
//            authLoginResponse.setStatus(1);
//            authLoginResponse.setLastLoginIp("127.0.0.1");
//            authLoginResponse.setLastLoginTime(1534837621348L);
//            authLoginResponse.setCreatorId("admin");
//            authLoginResponse.setCreateTime(1497160610259L);
//            authLoginResponse.setDeleted(0);
//            authLoginResponse.setRoleId("admin");
//            authLoginResponse.setLang("zh-CN");

            testList.get(0).setPassword("");


            String token;
            Date expirationTime = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000);
            token = JWT.create().withAudience(receiveLogin.getUsername())// 将 user id 保存到 token 里面,作为载荷
            .withExpiresAt(expirationTime)// 2小时后token过期
            .sign(Algorithm.HMAC256(receiveLogin.getPassword()));// 以 password 作为 token 的密钥


            testList.get(0).setToken(token);

            return ApiDataResponse.success(testList.get(0));
        }
        else
            return ApiDataResponse.fail(5000, "账号密码错误");
    }

    @PostMapping("/logout")
    public ApiDataResponse<Boolean> loging(String token) {
        return ApiDataResponse.success(true);
    }

}
