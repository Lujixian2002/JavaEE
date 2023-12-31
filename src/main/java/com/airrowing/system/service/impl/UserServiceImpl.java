package com.airrowing.system.service.impl;

import com.airrowing.system.pojo.TolAttendanceTable;
import com.airrowing.system.pojo.UserManList;
import com.airrowing.system.pojo.UserManListStr;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.airrowing.system.pojo.User;
import com.airrowing.system.service.UserService;
import com.airrowing.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author 28061
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-12-13 16:21:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserManListStr> getUserList(String nickname, String name,
                                            Integer gender, Integer maxHeight, Integer minHeight,
                                            Integer maxWeight, Integer minWeight, String phoneNumber){
        List<UserManList> userInfos = userMapper.selectAllMembers();
        // 使用 stream 和 filter 方法来筛选出名字中包含给定字符串的记录
        List<UserManList> filteredRecord = userInfos.stream()
                .filter(r -> Objects.requireNonNullElse(r.getUserRealName(), "").toLowerCase().contains(Objects.requireNonNullElse(name, "").toLowerCase()))
                .filter(r -> Objects.requireNonNullElse(r.getUserNickname(), "").toLowerCase().contains(Objects.requireNonNullElse(nickname, "").toLowerCase()))
                .filter(r -> Objects.requireNonNullElse(r.getUserWeight(), 0) <= maxWeight && Objects.requireNonNullElse(r.getUserWeight(), 0) >= minWeight)
                .filter(r -> Objects.requireNonNullElse(r.getUserHeight(), 0) <= maxHeight && Objects.requireNonNullElse(r.getUserHeight(), 0) >= minHeight)
                .filter(r -> gender == -1 || r.getUserGender() == gender)
                .filter(r -> Objects.requireNonNullElse(r.getUserPhoneNumber(), "").toLowerCase().contains(Objects.requireNonNullElse(phoneNumber, "").toLowerCase()))
                .collect(Collectors.toList());

        List<UserManListStr> userManListStrList = new ArrayList<>();
        // 进行 "男" or "女" 判断
        for (UserManList userInfo : filteredRecord) {
            // Assuming 1 represents male and 0 represents female
            String genderString = (userInfo.getUserGender() == 1) ? "男" : "女";

            // Create a new UserManListStr object and set the values
            UserManListStr userManListStr = new UserManListStr();
            userManListStr.setUserId(userInfo.getUserId());
            userManListStr.setUserNickname(userInfo.getUserNickname());
            userManListStr.setUserRealName(userInfo.getUserRealName());
            userManListStr.setUserGender(genderString);
            userManListStr.setUserHeight(userInfo.getUserHeight());
            userManListStr.setUserWeight(userInfo.getUserWeight());
            userManListStr.setUserPhoneNumber(userInfo.getUserPhoneNumber());

            // Add the modified object to the list
            userManListStrList.add(userManListStr);
        }

        return userManListStrList;


    }

    @Override
    public Boolean deleteUser(int userId){
        if(userMapper.deleteByUserId(userId)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<UserManListStr> getAppliedUserList(){
        List<UserManList> userInfos = userMapper.selectAllApplied();
        List<UserManListStr> userManListStrList = new ArrayList<>();
        // 进行 "男" or "女" 判断
        for (UserManList userInfo : userInfos) {
            // Assuming 1 represents male and 0 represents female
            String genderString = (userInfo.getUserGender() == 1) ? "男" : "女";

            // Create a new UserManListStr object and set the values
            UserManListStr userManListStr = new UserManListStr();
            userManListStr.setUserId(userInfo.getUserId());
            userManListStr.setUserNickname(userInfo.getUserNickname());
            userManListStr.setUserRealName(userInfo.getUserRealName());
            userManListStr.setUserGender(genderString);
            userManListStr.setUserHeight(userInfo.getUserHeight());
            userManListStr.setUserWeight(userInfo.getUserWeight());
            userManListStr.setUserPhoneNumber(userInfo.getUserPhoneNumber());

            // Add the modified object to the list
            userManListStrList.add(userManListStr);
        }
        return userManListStrList;
        // return userMapper.selectAllApplied();
    }

    /**
     * Refuse the application of one user
     * @param userId
     */
    @Override
    public void refuseApplication(int userId){
        userMapper.refuseApplication(userId);
    }

    /**
     * Commit the application to this club of one user
     * @param userId
     */
    @Override
    public void commitApplication(int userId){
        userMapper.commitApplication(userId);
    }
}




