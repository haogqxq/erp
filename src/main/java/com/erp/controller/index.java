package com.erp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 19:59
 * @description：
 * @modified By：
 */
@Slf4j
@Controller
@RequestMapping("/home")
public class index {
    @GetMapping
    public String index(Model model){
        log.info("test");
        return "home";
    }
}
