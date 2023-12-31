package com.airrowing.system.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginRoleInfo {
    String id;
    String name;
    String describe;
    int status;
    String creatorId;
    long createTime;
    int deleted;

    Set<LoginPermissions> permissions = new HashSet<>();

    public void addLoginPermissions(LoginPermissions loginPermissions){
        this.permissions.add(loginPermissions);
    }

}
