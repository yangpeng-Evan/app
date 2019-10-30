package com.qf.task;


import com.qf.entity.DevUser;
import com.qf.service.DevUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangpeng
 */
@Component
@Slf4j
public class DeleteInactiveUsersRegularly {

    @Resource
    private DevUserService devUserService;
    /**
     *  查询超过三天未激活的用户id信息
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void deleteNotActiveDevUserOverThreeDays() {
        //查询超过三天未激活的用户ids
        List<Integer> ids = devUserService.findAllInactiveDevUser();
        if (ids != null || ids.size() > 0){
            log.info("【定时删除任务】 定时删除超过三天未激活的用户任务执行，ids={}",ids);
            //3. 删除.in (1,23,4,5)
            devUserService.deleteByIds(ids);
        }
    }
}
