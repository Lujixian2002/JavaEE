package com.airrowing.system.pojo;

import lombok.Data;

@Data
public class LoginNav {
    private String name;
    private int parentId;
    private int id;
    LoginNavMeta meta;
    private String component;
    private String redirect;
    private String path;
//    private String redirect;

//    private String title;
//    private String path;

}
