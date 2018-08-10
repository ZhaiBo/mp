package com.zbhaha.mp.common;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

public enum ErrorCode implements IErrorCode {
    ERROR("E999999", "系统内部异常"),

    SUCCESS("E000000", "请求成功"),

    NULL("E000001", "参数为空"),

    FORMAT_ERROR("E000002","请求数据格式错误"),
    ;

    private String code;
    private String msg;

    ErrorCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
