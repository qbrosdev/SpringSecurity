package com.qbros.security.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //https://stackoverflow.com/a/24949164/3593084
    public final static String SECURED_API_REGEX = "/secure/*";
    public final static String SECURED_ADMIN_API_REGEX = "/secure/admin";
    public final static String SECURED_USER_API_REGEX = "/secure/user";



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("userA").password("pass").roles("ADMIN")
                .and()
                .withUser("userB").password("pass").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(SECURED_ADMIN_API_REGEX).hasRole("ADMIN")
                .antMatchers(SECURED_USER_API_REGEX).hasRole("USER")
                .and().httpBasic()
                .and().csrf().disable();
    }
}
