package com.qf.service;

import java.util.LinkedHashMap;

/**
 * shiro的过滤器链service.
 */
public interface FilterChainService {

    // 查询过滤器链信息
    LinkedHashMap<String, String> findFilterChainDefinition();
}
