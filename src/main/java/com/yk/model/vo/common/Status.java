package com.yk.model.vo.common;

public enum Status {
    SUCCESS(200, "ok"),
    ERROR(101, "阿哦，网络暂时有点忙碌，请稍后再试"),
    EXCEPTION(106, "业务异常"),
    ;

    private int code;

    private String message;

    private Status(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getCode());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
