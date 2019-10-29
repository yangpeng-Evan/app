
package com.qf.exception;

import com.qf.enums.AppEnum;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException {

    private Integer code;

    public AppException(AppEnum jxcEnum){
        super(jxcEnum.getMsg());
        this.code = jxcEnum.getCode();
    }

    public AppException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

}
