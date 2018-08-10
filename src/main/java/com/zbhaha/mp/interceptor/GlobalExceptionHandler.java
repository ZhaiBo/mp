package com.zbhaha.mp.interceptor;

import com.zbhaha.mp.common.BaseResponse;
import com.zbhaha.mp.common.CommonException;
import com.zbhaha.mp.common.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = CommonException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleCommonException(CommonException e) {
        LOGGER.error("业务异常:{}", e.getErrMsg());
        BaseResponse response = new BaseResponse();
        response.setError(e.getErrCode(), e.getErrMsg());
        return response;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleException(HttpMessageNotReadableException e) {
        LOGGER.error("请求数据格式格式错误");
        BaseResponse response = new BaseResponse();
        response.setError(ErrorCode.FORMAT_ERROR.getCode(), ErrorCode.FORMAT_ERROR.getMsg());
        return response;
    }
}
