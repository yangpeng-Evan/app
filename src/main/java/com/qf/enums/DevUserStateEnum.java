package com.qf.enums;

import lombok.Getter;

@Getter
public enum DevUserStateEnum {

    NOT_ACTIVE(0,"未激活!"),
    ACTIVE(1,"正常!");

    private Integer state;

    private String msg;

    DevUserStateEnum(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }
}
