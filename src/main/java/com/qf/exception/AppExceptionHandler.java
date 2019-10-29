package com.qf.exception;

import com.qf.util.R;
import com.qf.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler(AppException.class)
    public ResultVO jxc(AppException ex){
        return R.error(ex);
    }

}

