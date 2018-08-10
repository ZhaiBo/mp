package com.zbhaha.mp.common;

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -345062240553703190L;
    private String errCode;
    private String errMsg;

    public CommonException() {
    }

    public CommonException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
