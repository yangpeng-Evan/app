package com.qf.mapper;

import com.qf.entity.AppInfo;
import com.qf.vo.AppMaintainVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author yangpeng
 */
public interface AppInfoMapper extends Mapper<AppInfo> {

    /**
     * 查询app下载排行top5
     * @return
     */
    @Select("select software_name,downloads from app_info order by downloads desc limit 5")
    List<AppInfo> findOrderByDownloadsDescLimitFive();

    /**
     * 查询列表数据mapper接口
     * @param param
     * @return
     */

    //根据添加查询APP信息
    List<AppMaintainVO> findAppMaintain(Map<String, Object> param);
}
