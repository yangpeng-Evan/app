package com.qf.util;

import com.qf.enums.AppEnum;
import com.qf.exception.AppException;
import com.qf.vo.ResultVO;

public class R {

    public static ResultVO ok(Object data){
        ResultVO vo = new ResultVO(0,"",data);
        return vo;
    }

    public static ResultVO ok(){
        return ok(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO vo = new ResultVO(code,msg,null);
        return vo;
    }

    public static ResultVO error(AppException ex){
        ResultVO vo = new ResultVO(ex.getCode(),ex.getMessage(),null);
        return vo;
    }

    public static ResultVO error(AppEnum jxcEnum){
        ResultVO vo = new ResultVO(jxcEnum.getCode(),jxcEnum.getMsg(),null);
        return vo;
    }

}
