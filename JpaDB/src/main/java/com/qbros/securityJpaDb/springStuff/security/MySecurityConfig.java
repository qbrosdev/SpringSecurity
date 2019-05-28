package com.qbros.securityJpaDb.springStuff.security;

import com.qbros.securityJpaDb.persistance.entities.security.Role;
import com.qbros.securityJpaDb.service.security.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.h2.console.path}")
    private String h2ConsolePath;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    private final MyAccessDeniedHandler myAccessDeniedHandler;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //authorization settings---------------------------------------------------------------------------
                .authorizeRequests()
                /*open api*/
                .antMatchers("/open/**", h2ConsolePath + "/**").permitAll()
                /*role base access api*/
                .antMatchers("/secure/admin/**").hasAnyRole(Role.ADMIN.name())
                .antMatchers("/secure/user/**").hasRole(Role.USER.name())
                /*for accessing the rest of API, the users just need to be authentication (no specific role needed)*/
                .anyRequest().authenticated()
                //authentication mechanisms--------------------------------------------------------------------------
                /*provide basic authentication for users*/
                .and().httpBasic()
                /*provide form authentication (but we not need it here)*/
                //.and().formLogin()
                //customize exception handling-----------------------------------------------------------------------
                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)
                .and().exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint)
                //---------------------------------------------------------------------------------------------------
                /*configure X-Frame-Options to fix h2 console: https://stackoverflow.com/a/53399807/3593084*/
                .and().headers().frameOptions().sameOrigin()
                //----------------------------------------------------------------------------------------------------
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }
}
