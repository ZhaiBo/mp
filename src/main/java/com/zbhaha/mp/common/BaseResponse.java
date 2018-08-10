package com.zbhaha.mp.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -6363600429268457906L;
    private String rtnCode;
    private String rtnMsg;

    public void setSuccess() {
        this.rtnCode = ErrorCode.SUCCESS.getCode();
        this.rtnMsg = ErrorCode.SUCCESS.getMsg();
    }

    public void setError() {
        this.rtnCode = ErrorCode.ERROR.getCode();
        this.rtnMsg = ErrorCode.ERROR.getMsg();
    }

    public void setError(String rtnCode, String rtnMsg) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
    }
}
