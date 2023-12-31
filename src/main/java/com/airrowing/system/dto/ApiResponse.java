package com.airrowing.system.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cinea
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ApiResponse extends ApiBaseResponse {
    /**
     * 返回10000为成功，否则为失败
     */
    int code;

    /**
     * 若失败，在此处填写失败原因；
     */
    String msg;

    /**
     * 操作成功，无需返回任何东西
     */
    public static ApiResponse success(){
        return ApiResponse.builder().code(10000).msg("成功").build();
    }

    /**
     * 操作失败
     */
    public static ApiResponse fail(int code, String msg){
        return ApiResponse.builder().code(code).msg(msg).build();
    }
}
