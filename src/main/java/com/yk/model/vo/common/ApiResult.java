package com.yk.model.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel("返回结果")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> implements Serializable {
    @ApiModelProperty(value = "状态码")
    private Integer retCode = 0;

    @ApiModelProperty(value = "状态信息")
    private String retMsg;

    @ApiModelProperty(value = "返回的数据")
    private T data;

    public ApiResult(Status status) {
        this.retCode = status.getCode();
        this.retMsg = status.getMessage();
    }

    public static <T> ApiResult<T> build(Integer code, String message, T data) {
        return new ApiResult<T>(code, message, data);
    }

    public static ApiResult buildSuccess() {
        ApiResult apiResult = new ApiResult(Status.SUCCESS);
        return apiResult;
    }

    public static <T> ApiResult<T> buildSuccess(T data) {
        ApiResult<T> apiResult = new ApiResult(Status.SUCCESS);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult buildFailed() {
        ApiResult apiResult = new ApiResult(Status.ERROR);
        return apiResult;
    }

    public static ApiResult buildFailed(String message) {
        ApiResult apiResult = new ApiResult(Status.ERROR);
        apiResult.setRetMsg(message);
        return apiResult;
    }

    public static <T> ApiResult<T> buildFailed(T data) {
        ApiResult apiResult = new ApiResult(Status.ERROR);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult buildException(String message) {
        ApiResult apiResult = new ApiResult(Status.EXCEPTION);
        apiResult.setRetMsg(message);
        return apiResult;
    }
}
