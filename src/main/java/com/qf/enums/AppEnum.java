package com.qf.enums;

import lombok.Getter;

@Getter
public enum AppEnum {

    PARAM_ERROR(1,"参数不合法!!"),

    DEV_USER_EXISTS(21,"开发者用户名已经存在!!"),

    DEV_USER_REGISTER_ERROR(22,"注册账号失败!!"),

    DEV_USER_ACTIVE_ERROR(23,"用户已经激活!!"),

    DEV_USER_NOT_EXISTS(24,"用户不存在!!"),
    SEND_EMAIL_ERROR(33,"邮件发送失败!!"),
    UPDATE_DEVUSER_STATE_ERROR(43,"修改用户状态失败！！"),
    DEVUSER_NOT_ACTIVE_ERROR(50,"用户未激活！！")

    ;

    private Integer code;

    private String msg;

    AppEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
