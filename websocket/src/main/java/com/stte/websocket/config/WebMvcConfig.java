package com.stte.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * create by BloodFly at 2018/12/19
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // 为ws.html提供便捷的路径映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("ws");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/chat").setViewName("chat");
    }
}
