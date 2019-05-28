package com.qbros.securityJpaDb.controller;

import com.qbros.securityJpaDb.service.SimpleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/secureMethod/")
public class SecureMethod {

    private SimpleService simpleService;

    @GetMapping("test1")
    private String test1(){
        return simpleService.test1();
    }

    @GetMapping("test2")
    private String test2(){
        return simpleService.test2();
    }

    @GetMapping("test3")
    private String test3(){
        return simpleService.test3();
    }
}
