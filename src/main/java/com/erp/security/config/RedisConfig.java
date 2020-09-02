package com.erp.security.config;

import com.erp.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 12:54
 * @description：Redis配置类
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
