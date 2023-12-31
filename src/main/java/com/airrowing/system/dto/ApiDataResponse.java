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
public class ApiDataResponse<T> extends ApiBaseResponse {
    /**
     * 返回10000为成功，否则为失败
     */
    int code;

    /**
     * 若失败，在此处填写失败原因；
     */
    String msg;

    /**
     * 返回的数据
     */
    T data;

    /**
     * 操作成功，返回数据
     */
    public static <T> ApiDataResponse<T> success(T data) {
        return new ApiDataResponse<T>(10000, "成功", data);
    }

    /**
     * 操作失败，返回代码和原因
     */
    public static <T> ApiDataResponse<T> fail(int code, String msg){
        return new ApiDataResponse<>(code,msg,null);
    }
}
