package com.ticketgo.security;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
*/
public class SecurityConfig {

    /*
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }*/
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configer ->
                configer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("employee")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("employee")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("manager")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("manager")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("admin")
        );*/
    //use http basic authentication
    //http.httpBasic();
    //disable cross site request forgery(CSRF)
    //in general not required for stateless rest that use post,put,delete, and/or patch
    //http.csrf(AbstractHttpConfigurer::disable);
    //return  http.build();

/*
*     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // 允许所有用户访问"/public/**"
                .anyRequest().authenticated() // 其他任意请求都需要身份验证
                .and()
                .httpBasic(); // 使用HTTP基本认证
    }

}

// 配置用户认证信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
    }


 // 配置密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 */ 
    //}

}