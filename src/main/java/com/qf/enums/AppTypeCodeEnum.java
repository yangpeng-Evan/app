package com.qf.enums;

import lombok.Getter;

@Getter
public enum AppTypeCodeEnum {
    APP_STATUS("APP_STATUS","APP状态"),

    APP_FLATFORM("APP_FLATFORM","所属平台"),

    PUBLISH_STATUS("PUBLISH_STATUS","发布状态");

    private String typeCode;

    private String typeName;

    AppTypeCodeEnum(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
}
