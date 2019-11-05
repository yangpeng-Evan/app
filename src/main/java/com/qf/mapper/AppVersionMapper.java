package com.qf.mapper;

import com.qf.entity.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangpeng
 */
public interface AppVersionMapper extends Mapper<AppVersion> {
    /**
     * 根据id查询最新的三个版本信息
     * @param id
     * @return
     */
    @Select("select v.version_no version_no, v.version_size version_size,  v.apk_file_name apk_file_name, v.download_link download_link, v.updated updated, i.software_name software_name, d.value_name publish_status_name from app_version v, app_info i, data_dictionary d where v.app_id = i.id and v.publish_status = d.value_id and d.type_code = 'PUBLISH_STATUS' and app_id = #{id} limit 3")
    List<AppVersion> findNewThreeVersions(@Param("id") Integer id);
}
