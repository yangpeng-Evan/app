package com.qf.enums;

import lombok.Getter;

/**
 * @author yangpeng
 */
@Getter
public enum PublishStatusEnum {
    NOT_PUBLISH(1,"不发布"),
    ALREADY_PUBLISH(2,"已发布"),
    PRE_PUBLISH(3,"预发布")

    ;


    private Integer code;

    private String msg;

    PublishStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
