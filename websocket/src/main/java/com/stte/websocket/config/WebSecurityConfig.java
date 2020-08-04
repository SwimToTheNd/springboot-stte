package com.stte.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * create by BloodFly at 2018/12/20
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 设置Spring Security对/和/login不拦截
                .antMatchers("/","/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                // 设置Spring Security登陆页面访问路径为/login
                .loginPage("/login")
                //登陆成功后跳转页面
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中配置两个用户的用户名、密码、角色
        auth.inMemoryAuthentication()
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                    .withUser("wisely").password("wisely").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 让Spring Security不拦截/resources/static/目录下的静态文件
        web.ignoring().antMatchers("/resources/static/**");
    }
}

