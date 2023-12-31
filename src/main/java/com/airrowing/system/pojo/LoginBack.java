package com.airrowing.system.pojo;

import lombok.Data;

@Data
public class LoginBack {
    private String id;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private int status;
    private String telephone;
    private String lastLoginIp;
    private long lastLoginTime;
    private String creatorId;
    private long createTime;
    private String merchantCode;
    private int deleted;
    private String roleId;
    private LoginRoleInfo role;
}
