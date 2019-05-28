package com.qbros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */

@RestController
@RequestMapping("/secure/hello")
public class SecuredAPI {


    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
