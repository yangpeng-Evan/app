package com.qf.service.impl;

import com.qf.entity.AppInfo;
import com.qf.entity.AppVersion;
import com.qf.enums.AppEnum;
import com.qf.enums.PublishStatusEnum;
import com.qf.exception.AppException;
import com.qf.mapper.AppVersionMapper;
import com.qf.service.AppInfoService;
import com.qf.service.AppVersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public List<AppVersion> findNewThreeVersions(Integer id) {
        List<AppVersion> list = appVersionMapper.findNewThreeVersions(id);
        return list;
    }

    @Override
    @Transactional
    public void add(AppVersion appVersion) {
        appVersion.setPublishStatus(PublishStatusEnum.PRE_PUBLISH.getCode());
        AppInfo appInfo = appInfoService.findById(appVersion.getAppId());
        appVersion.setApkFileName(appInfo.getApkName()+"-"+appVersion.getVersionNo());
        int count = appVersionMapper.insertSelective(appVersion);
        if (count != 1){
            log.error("【新增版本号】 新增版本号失败，未知原因");
            throw new AppException(AppEnum.UNKNOWN_ERROR);
        }
        appInfo.setVersionId(appVersion.getId());
        appInfoService.updateVersionId(appInfo);
    }
}
