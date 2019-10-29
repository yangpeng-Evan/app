package com.qf.service.impl;

import com.qf.mapper.FilterChainMapper;
import com.qf.service.FilterChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class FilterChainServiceImpl implements FilterChainService {

    @Autowired
    private FilterChainMapper filterChainMapper;


    @Override
    public LinkedHashMap<String, String> findFilterChainDefinition() {
        return filterChainMapper.findOrderByOrderedAsc();
    }
}
