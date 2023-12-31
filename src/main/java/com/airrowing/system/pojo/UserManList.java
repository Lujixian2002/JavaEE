package com.airrowing.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserManList {
    private int userId;
    private String userNickname;
    private String userRealName;
    private int userGender;
    private int userHeight;
    private int userWeight;
    private String userPhoneNumber;
}
