package com.qbros.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@RestController
@RequestMapping("insecure/test")
public class InSecureApi {

    @GetMapping
    private String test(){
        return "Test inSecure";
    }
}
