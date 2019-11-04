package com.qf.service;

import com.qf.entity.AppInfo;
import com.qf.vo.DownloadsVO;
import com.qf.vo.LayUiTableVO;

import java.util.List;
import java.util.Map;

/**
 * appInfo的service接口
 */
public interface AppInfoService {

    //1. 查询下载量的TOP FIVE
    List<DownloadsVO> findDownloadsTopFive();

    /**
     * app维护页面table信息查询接口
     * @param param
     * @return
     */
    LayUiTableVO findAllAppInfo(Map<String, Object> param);


    /**
     * 添加app基础信息接口
     * @param appInfo
     */
    void add(AppInfo appInfo);

    /**
     * 更新app状态，上架
     * @param ids
     */
    void up(Integer[] ids);

    /**
     * 更新app状态，下架
     * @param ids
     */
    void down(Integer[] ids);
}
