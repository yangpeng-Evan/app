package com.qf.mapper;

import com.qf.entity.FilterChain;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;

public interface FilterChainMapper extends Mapper<FilterChain> {


    @Select("select url,filter from filter_chain order by ordered asc")
    LinkedHashMap<String,String> findOrderByOrderedAsc();



}
