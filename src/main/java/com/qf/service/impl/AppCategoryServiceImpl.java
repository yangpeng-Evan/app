package com.qf.service.impl;

import com.qf.entity.AppCategory;
import com.qf.mapper.AppCategoryMapper;
import com.qf.service.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Resource
    private AppCategoryMapper appCategoryMapper;


    // 根据parentId查询分类
    @Override
    public List<AppCategory> findByParentId(int parentId) {
        //1. 封装查询条件.
        AppCategory param = new AppCategory();
        param.setParentId(parentId);
        //2. 查询.
        List<AppCategory> list = appCategoryMapper.select(param);
        //3. 返回
        return list;
    }
}
