package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.AppCategory;
import com.qf.entity.AppInfo;
import com.qf.entity.DevUser;
import com.qf.enums.AppEnum;
import com.qf.enums.AppStatusEnum;
import com.qf.exception.AppException;
import com.qf.mapper.AppInfoMapper;
import com.qf.mapper.DevUserMapper;
import com.qf.service.AppInfoService;
import com.qf.vo.AppMaintainVO;
import com.qf.vo.DownloadsVO;
import com.qf.vo.LayUiTableVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<DownloadsVO> findDownloadsTopFive() {
        //1. 查询下载量最大的前5名
        List<AppInfo> appInfos = appInfoMapper.findOrderByDownloadsDescLimitFive();

        //2. 封装数据.  lambda表达式
        List<DownloadsVO> data = new ArrayList<>();
        for (AppInfo appInfo : appInfos) {
            DownloadsVO vo = new DownloadsVO(appInfo.getSoftwareName(),appInfo.getDownloads());
            data.add(vo);
        }
        //4. 返回
        return data;
    }

    @Override
    public LayUiTableVO findAllAppInfo(Map<String, Object> param) {
        //开启分页
        PageHelper.startPage((int)param.get("page"),(int)param.get("limit"));
        //调用mapper查询数据
        List<AppMaintainVO> appMaintainVOList = appInfoMapper.findAppMaintain(param);
        //封装pageInfo
        PageInfo<AppMaintainVO> pageInfo = new PageInfo<>(appMaintainVOList);
        //声明layuitablevo并设置count
        LayUiTableVO layUiTableVO = new LayUiTableVO();
        layUiTableVO.setCount(pageInfo.getTotal());
        //将appMaintainVOList设置到LayUiTableVO的data中
        layUiTableVO.setData(appMaintainVOList);
        //返回数据
        return layUiTableVO;
    }

    @Override
    @Transactional
    public void add(AppInfo appInfo) {
        //封装数据
        appInfo.setAppStatus(AppStatusEnum.CHECK_WAIT.getStatus());
        Integer devId = ((DevUser) SecurityUtils.getSubject().getPrincipal()).getId();
        appInfo.setDevId(devId);
        //执行添加
        int count = appInfoMapper.insertSelective(appInfo);
        //判断添加结果
        if (count != 1){
            log.error("【添加app基础信息】 添加app'基础信息失败！appInfo={}",appInfo);
            throw new AppException(AppEnum.SAVE_BASE_INFO_ERROR);
        }
    }

    @Override
    @Transactional
    public void up(Integer[] ids) {
        //封装查询条件
        Example example = new Example(AppInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        //查询数据
        List<AppInfo> list = appInfoMapper.selectByExample(example);
        //循环遍历判断app状态
        for (AppInfo appInfo : list) {
            int status = appInfo.getAppStatus();
            if (status == AppStatusEnum.CHECK_WAIT.getStatus() ||
                status == AppStatusEnum.CHECK_NOT_PASS.getStatus() ||
                status == AppStatusEnum.ON_SALE.getStatus()){
                log.error("【app上架】 app上架失败！appInfo={}",appInfo);
                throw new AppException(AppEnum.UP_SALE_ERROR);
            }
        }
        //执行修改
        AppInfo appInfo = new AppInfo();
        appInfo.setAppStatus(AppStatusEnum.ON_SALE.getStatus());
        appInfo.setOnSaleDate(new Date());
        int count = appInfoMapper.updateByExampleSelective(appInfo, example);
        //判断是否修改成功
        if (count != ids.length){
            log.error("【app上架】 app上架失败！appInfo={}",appInfo);
            throw new AppException(AppEnum.UP_SALE_ERROR);
        }
    }

    @Override
    public void down(Integer[] ids) {
        //封装查询条件
        Example example = new Example(AppInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        //查询数据
        List<AppInfo> list = appInfoMapper.selectByExample(example);
        //循环遍历判断app状态
        for (AppInfo appInfo : list) {
            int status = appInfo.getAppStatus();
            if (status == AppStatusEnum.OFF_SALE.getStatus() ||
                status == AppStatusEnum.CHECK_NOT_PASS.getStatus() ||
                status == AppStatusEnum.CHECK_WAIT.getStatus() ||
                status == AppStatusEnum.CHECK_ALREADY.getStatus()){
                log.error("【app下架】 app下架失败01！appInfo={}",appInfo);
                throw new AppException(AppEnum.DOWN_SALE_ERROR);
            }
        }
        //执行修改
        AppInfo appInfo = new AppInfo();
        appInfo.setAppStatus(AppStatusEnum.OFF_SALE.getStatus());
        appInfo.setOnSaleDate(new Date());
        int count = appInfoMapper.updateByExampleSelective(appInfo, example);
        //判断是否修改成功
        if (count != ids.length){
            log.error("【app下架】 app下架失败02！appInfo={}",appInfo);
            throw new AppException(AppEnum.DOWN_SALE_ERROR);
        }
    }
}
