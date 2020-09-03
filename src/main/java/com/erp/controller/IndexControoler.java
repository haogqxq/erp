package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：首页控制器
 */
@Controller
public class IndexControoler {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
