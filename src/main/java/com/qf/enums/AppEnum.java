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
    DEVUSER_NOT_ACTIVE_ERROR(50,"用户未激活！！"),
    SAVE_BASE_INFO_ERROR(60,"添加app基础信息失败！！"),
    UP_SALE_ERROR(70,"app上架失败！！"),
    DOWN_SALE_ERROR(71,"app下架失败！！"),
    DELETE_APPINFO_ERROR(81,"app删除失败！！"),

    UNKNOWN_ERROR(100,"未知原因！"),
    SESSION_ISEMPTY(110,"session不能为空！！"),
    SESSIONID_ISEMPTY(111,"sessionId不能为空！！")

    ;

    private Integer code;

    private String msg;

    AppEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
