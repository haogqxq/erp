package com.erp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:25
 * @description ：MyBatis配置类
 */
@Configuration
@MapperScan("com.erp.mbg.mapper")
public class MyBatisConfig {
}
