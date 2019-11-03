package com.qf.service;

import com.qf.entity.DataDictionary;

import java.util.List;

/**
 * 字典表的service接口
 */
public interface DataDictionaryService {

    // 1. 根据typeCode查询全部数据
    List<DataDictionary> findByTypeCode(String typeCode);
}
