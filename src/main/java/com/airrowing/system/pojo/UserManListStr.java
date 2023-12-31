package com.airrowing.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserManListStr {
    private int userId;
    private String userNickname;
    private String userRealName;
    private String userGender;
    private int userHeight;
    private int userWeight;
    private String userPhoneNumber;
}
