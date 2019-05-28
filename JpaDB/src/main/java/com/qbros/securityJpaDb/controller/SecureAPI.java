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
@RestController
@RequestMapping("/secure/")
public class SecureAPI {

    @GetMapping("admin/test")
    private String test(){
        return "test admin";
    }

    @GetMapping("user/test")
    private String test2(){
        return "test user";
    }

    @GetMapping("authenticated/test")
    private String test3(){
        return "test authenticated";
    }
}
