package com.qf.vo;

import lombok.Data;

/**
 * @author yangpeng
 */
@Data
public class AppMaintainVO {

    // 操作app时,需要用的到一些id
    private Long id;
    private Integer flatformId;
    private Integer appStatus;
    private Integer categoryLevel1;
    private Integer categoryLevel2;
    private Integer categoryLevel3;
    private Integer versionId;

    //页面需要展示的数据
    private String softwareName;
    private String softwareSize;
    private String flatformName;
    private String appStatusName;
    private String categoryLevel1Name;
    private String categoryLevel2Name;
    private String categoryLevel3Name;
    private String downloads;
    private String versionNo;
}
