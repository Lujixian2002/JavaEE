package com.airrowing.system.dto;

/**
 * @author cineazhan
 */
public abstract class ApiBaseResponse {
    /**
     * 返回10000为成功，否则为失败
     */
    int code;

    /**
     * 若失败，在此处填写失败原因；
     */
    String msg;
}
