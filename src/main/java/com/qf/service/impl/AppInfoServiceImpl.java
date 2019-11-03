package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.AppCategory;
import com.qf.entity.AppInfo;
import com.qf.mapper.AppInfoMapper;
import com.qf.mapper.DevUserMapper;
import com.qf.service.AppInfoService;
import com.qf.vo.AppMaintainVO;
import com.qf.vo.DownloadsVO;
import com.qf.vo.LayUiTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
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
}
