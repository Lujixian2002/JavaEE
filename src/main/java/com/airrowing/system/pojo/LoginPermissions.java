package com.airrowing.system.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginPermissions {
    String roleId;
    String permissionId;
    String permissionName;
    Set<LoginActionEntity> actionEntitySet = new HashSet<>();
    String actionList;
    String dataAccess;

    public void addLoginActionEntities(LoginActionEntity loginActionEntity){
        this.actionEntitySet.add(loginActionEntity);
    }

}
