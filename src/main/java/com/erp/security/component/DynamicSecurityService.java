package com.erp.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2 11:54
 * @description：动态权限相关业务类
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
