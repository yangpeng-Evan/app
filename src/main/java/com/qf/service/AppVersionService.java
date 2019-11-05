package com.qf.service;

import com.qf.entity.AppVersion;

import java.util.List;

/**
 * @author yangpeng
 */
public interface AppVersionService {
    /**
     * 根据id查询app版本信息
     * @param id
     * @return
     */
    List<AppVersion> findNewThreeVersions(Integer id);

    /**
     * 新增app版本信息
     * @param appVersion
     */
    void add(AppVersion appVersion);
}
