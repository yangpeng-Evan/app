package com.qf.enums;

import lombok.Getter;

/**
 * @author yangpeng
 */
@Getter
public enum AppStatusEnum {
    CHECK_WAIT(1,"待审核"),
    CHECK_ALREADY(2,"已审核"),
    CHECK_NOT_PASS(3,"审核驳回"),
    ON_SALE(4,"上架"),
    OFF_SALE(5,"下架")
    ;

    private Integer status;

    private String msg;

    AppStatusEnum(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }
}

