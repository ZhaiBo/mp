package com.zbhaha.mp.utils;

import com.zbhaha.mp.common.CommonException;
import com.zbhaha.mp.common.ErrorCode;
import lombok.extern.java.Log;
import org.springframework.util.StringUtils;

@Log
public class CheckUtils {
    public static void checkNotNull(Object value, String valueName) {
        if(value == null){
            throw new CommonException(ErrorCode.NULL.getCode(), valueName + " is null");
        }
        if (StringUtils.isEmpty(value)) {
            throw new CommonException(ErrorCode.NULL.getCode(), valueName + " is null");
        }
    }
}
