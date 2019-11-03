package com.qf.vo;

import lombok.Data;

/**
 * @author yangpeng
 */
@Data
public class LayUiTableVO {

       /* "code": 0,
            "msg": "",
            "count": 1000, // 数据的总条数
            "data"*/
    private Integer code = 0;

    private String msg = "";

    private Long count = 0L;

    private Object data = null;
}
