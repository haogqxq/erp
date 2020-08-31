package com.erp.config;

import com.erp.dao.UserRoleRelationDao;
import com.erp.mbg.model.Permission;
import com.erp.mbg.model.Resource;
import com.erp.mbg.model.Role;
import com.erp.mbg.model.UserRoleRelation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/31 16:56
 * @description：
 * @modified By：
 */
@Configuration
@MapperScan(basePackages = "com.erp.dao")
public class JavaConfig {
}
