package com.mimehoo.hrm.common.handler;

import com.mimehoo.hrm.common.entity.Result;
import com.mimehoo.hrm.common.exception.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e){
        if (e.getClass() == CommonException.class) {
            CommonException commonException = (CommonException) e;
            return new Result(commonException.getResultCode());
        } else {
            return Result.ERROR();
        }
    }
}
