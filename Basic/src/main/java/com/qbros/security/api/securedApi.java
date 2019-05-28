package com.qbros.security.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@RestController
@RequestMapping("/secure")
public class securedApi {

    @GetMapping("/admin")
    private String testAdmin(@AuthenticationPrincipal final UserDetails userDetails){
        /**
         * we can even check authentication parameters in the api itself (after it passes the security filter)
         */
        System.out.println(userDetails);
        return "Test admin Secured";
    }

    @GetMapping("/user")
    private String testUser(){
        return "Test user Secured";
    }
}
