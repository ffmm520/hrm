package com.mimehoo.hrm.common.exception;

import com.mimehoo.hrm.common.entity.ResultCode;
import lombok.Getter;

@Getter
public class CommonException extends Exception{
    private static final long serialVersionID = 131231231231L;
    private ResultCode resultCode = ResultCode.SERVER_ERROR;

    public CommonException() {
    }


    public CommonException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }
}
