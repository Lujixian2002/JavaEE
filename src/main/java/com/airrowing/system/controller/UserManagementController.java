package com.airrowing.system.controller;


import com.airrowing.system.dto.ApiDataResponse;
import com.airrowing.system.dto.ApiResponse;
import com.airrowing.system.pojo.UserManList;
import com.airrowing.system.pojo.UserManListStr;
import com.airrowing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // 跨域
@RequestMapping("/api/userManagement")
public class UserManagementController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ApiDataResponse<List<UserManListStr>> getUserList(@RequestParam(required = false) String nickname,
                                                             @RequestParam(required = false) String name,
                                                             @RequestParam(required = false) Integer gender,
                                                             @RequestParam(required = false) Integer maxHeight,
                                                             @RequestParam(required = false) Integer minHeight,
                                                             @RequestParam(required = false) Integer maxWeight,
                                                             @RequestParam(required = false) Integer minWeight,
                                                             @RequestParam(required = false) String phoneNumber) {

        // Check for null values and provide default values if needed
        Integer genderValue = (gender != null) ? gender : -1;
        Integer maxHeightValue = (maxHeight != null) ? maxHeight : Integer.MAX_VALUE;
        Integer minHeightValue = (minHeight != null) ? minHeight : Integer.MIN_VALUE;

        Integer maxWeightValue = (maxWeight != null) ? maxWeight : Integer.MAX_VALUE;
        Integer minWeightValue = (minWeight != null) ? minWeight : Integer.MIN_VALUE;

        return ApiDataResponse.success(userService.getUserList(nickname, name, genderValue,
                maxHeightValue, minHeightValue, maxWeightValue, minWeightValue, phoneNumber));
    }
    @DeleteMapping("/delete")
    public ApiResponse deleteUser(@RequestParam(required = true) int userId){

        if(userService.deleteUser(userId)){
            return ApiResponse.success();
        } else {
            return ApiResponse.fail(500,"删除失败");
        }
    }
    @GetMapping("/getAllApplied")
    public ApiDataResponse getAllApplied(){
        return ApiDataResponse.success(userService.getAppliedUserList());
    }

    @PostMapping("/conductApplication")
    public ApiResponse conductApplication(@RequestParam(required = true) int userId,
                                              @RequestParam(required = true) int conduct){
        if (conduct == 0) {
            userService.commitApplication(userId);
        } else {
            userService.refuseApplication(userId);
        }
        return ApiResponse.success();
    }
}
