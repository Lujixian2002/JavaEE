package com.airrowing.system.service;

import com.airrowing.system.pojo.UserManList;
import com.airrowing.system.pojo.User;
import com.airrowing.system.pojo.UserManListStr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 28061
* @description 针对表【user】的数据库操作Service
* @createDate 2023-12-13 16:21:48
*/
public interface UserService extends IService<User> {
    /**
     * 获取所有用户的信息
     * @param nickname
     * @param name
     * @param gender
     * @param maxHeight
     * @param minHeight
     * @param maxWeight
     * @param minWeight
     * @param phoneNumber
     * @return
     */
    List<UserManListStr> getUserList(String nickname, String name,
                                     Integer gender, Integer maxHeight, Integer minHeight,
                                     Integer maxWeight, Integer minWeight, String phoneNumber);
    Boolean deleteUser(int userId);

    List<UserManListStr> getAppliedUserList();


    void refuseApplication(int userId);

    void commitApplication(int userId);

}
