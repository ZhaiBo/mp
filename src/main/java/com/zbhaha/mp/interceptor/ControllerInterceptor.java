/*
package com.zbhaha.mp.interceptor;

import com.zbhaha.mp.common.BaseResponse;
import com.zbhaha.mp.common.CommonException;
import com.zbhaha.mp.common.ErrorCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Configuration
public class ControllerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Pointcut("execution(* com.zbhaha.mp.controller..*(..))&& @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    @Around("controllerMethodPointcut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        LOGGER.info("Method {[ ]} Start Execute", methodName);
        Object[] args = joinPoint.getArgs();

        Class<?> returnType = method.getReturnType();
        boolean isException = false;
        Object exceptionObj = null;
        Object result = null;

        try {
            result = joinPoint.proceed(args);
        } catch (CommonException e) {
            LOGGER.error("Method:{[ ]} BizException:{} {}", methodName, e.getErrCode(), e.getErrMsg());
            exceptionObj = setExceptionResponse(returnType, e.getErrCode(), e.getErrMsg());
            isException = true;
        } catch (RuntimeException e) {
            LOGGER.error("Method:{[ ]} RunTimeException:{} {} ",
                    methodName, e.getMessage(), e.getCause());
            isException = true;
        } catch (Exception e) {
            LOGGER.error("Method:{[ ]} Exception:{} {} {}",
                    methodName, e.getMessage(), e.getCause());
            isException = true;
        } catch (Throwable throwable) {
            LOGGER.error("Method:{[ ]} Throwable:{} {}",
                    methodName, throwable.getMessage(), throwable.getCause());
            isException = true;
        }

        if (isException) {
            if (exceptionObj != null) {
                result = exceptionObj;
            } else {
                if (BaseResponse.class.isAssignableFrom(returnType)) {
                    result = setExceptionResponse(returnType, ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg());
                }
            }
        }

        LOGGER.info("Method {[ ]} Execute Over!", methodName);
        return result;
    }

    Object setExceptionResponse(Class<?> clazz, String errCode, String errMsg) {
        Object response = null;
        try {
            response = clazz.newInstance();
            Method setResult = clazz.getMethod("setError", String.class, String.class);
            setResult.invoke(response, errCode, errMsg);
        } catch (InstantiationException e) {
            LOGGER.error("InstantiationException: {} {}", e.getMessage(), e.getCause());
        } catch (IllegalAccessException e) {
            LOGGER.error("IllegalAccessException: {} {}", e.getMessage(), e.getCause());
        } catch (NoSuchMethodException e) {
            LOGGER.error("NoSuchMethodException: {} {}", e.getMessage(), e.getCause());
        } catch (InvocationTargetException e) {
            LOGGER.error("InvocationTargetException: {} {}", e.getMessage(), e.getCause());
        }
        return response;
    }
}
*/
