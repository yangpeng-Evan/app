package com.qf.mapper;

import com.qf.entity.DevUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangpeng
 */
public interface DevUserMapper extends Mapper<DevUser> {
    /**
     * 查询查过三天未激活的用户信息
     */
    @Select("select id from dev_user where dev_state = 0 and created < now() - interval 3 day")
    List<Integer> findAllInactiveDevUser();
}
