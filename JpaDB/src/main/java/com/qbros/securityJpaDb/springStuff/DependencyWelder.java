package com.qbros.securityJpaDb.springStuff;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */
@Component
public class DependencyWelder {

    @Bean
    BCryptPasswordEncoder provideEncoder(){
        return new BCryptPasswordEncoder();
    }
}
