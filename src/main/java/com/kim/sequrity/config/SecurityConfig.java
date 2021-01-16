package com.kim.sequrity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 활성화 "스프링 시큐리티 필터가 스피링 필터체인에 등록됨 "
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //해당 메서드의 리턴되는 메서드를 어디서든 씀
    //패스워드를 인코딩을 하기위한 빈
    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/user/**").authenticated() //이주소로오면 인증  필요
            .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") //머드민이나 매니저
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")  //어드민 가능
            .anyRequest().permitAll() //누구나 들어갈수 있음
            .and()
            .formLogin()
            .loginPage("/loginForm")

        ;

    }
}
