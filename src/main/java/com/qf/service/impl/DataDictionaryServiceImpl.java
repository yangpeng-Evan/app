package com.qf.service.impl;

import com.qf.entity.DataDictionary;
import com.qf.mapper.DataDictionaryMapper;
import com.qf.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;


    // 查询字典表信息.(所属平台和app状态)
    @Override
    public List<DataDictionary> findByTypeCode(String typeCode) {
        //1. 封装查询条件.
        DataDictionary param = new DataDictionary();
        param.setTypeCode(typeCode);
        //2. 执行查询.
        List<DataDictionary> list = dataDictionaryMapper.select(param);
        //3. 返回
        return list;
    }

}
