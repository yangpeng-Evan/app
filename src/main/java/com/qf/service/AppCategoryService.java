package com.qf.service;

import com.qf.entity.AppCategory;

import java.util.List;

/**
 * APP分类的service接口
 */
public interface AppCategoryService {

    //1. 根据parentId查询app分类信息
    List<AppCategory> findByParentId(int parentId);
}
