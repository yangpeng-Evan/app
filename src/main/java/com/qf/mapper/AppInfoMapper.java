package com.qf.mapper;

import com.qf.entity.AppInfo;
import com.qf.vo.AppMaintainVO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AppInfoMapper extends Mapper<AppInfo> {

    @Select("select software_name,downloads from app_info order by downloads desc limit 5")
    List<AppInfo> findOrderByDownloadsDescLimitFive();

    List<AppMaintainVO> findAppMaintain(Map<String, Object> param);
}
