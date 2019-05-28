package com.qbros.securityJpaDb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */
@RestController
@RequestMapping("/open/")
public class OpenAPI {

    @GetMapping("test/")
    private String test(){
        return "test open";
    }

}
