package com.airrowing.system.pojo;

import lombok.Data;

@Data
public class LoginNavMeta {
    String title;
    String icon;
    boolean show;
    String target;
    boolean hiddenHeaderContent;
    boolean hideHeader;
    boolean hideChildren;
}
