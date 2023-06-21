package com.ss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// 自定义的ss配置类
@Configuration
public class SecurityConfig2  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()   // 设置登录页面
                .loginPage("/login.html")
                // 设置提交处理的路径
                .loginProcessingUrl("/test/login")
                // 设置登录成功后跳转路径
                .defaultSuccessUrl("/test/index")
                // 登录失败路径
                .failureForwardUrl("/fail")
                //  获取登录用户名
                .usernameParameter("loginusername")
                // 获取登录密码
                .passwordParameter("loginpassword")
                // 允许操作
                .permitAll()
                // 设置哪些需要被放行
                .and()
                .authorizeRequests()
                .antMatchers("/","/test/hello","/test/login").permitAll()

                // 当前认证通过后的用户，只有具备某个权限，才能访问
                // .antMatchers("/test/index").hasAuthority("superadmin")

                // 其他路径都需要认证
                .anyRequest().authenticated()

                // 禁止CRF 防护  （注意此代码如果不加，会登录不了）
                .and().csrf().disable();

    }
}