package com.qbros.controller;

import com.qbros.controller.dto.RequestJwtDTO;
import com.qbros.jwtSecurity.jwtSecurity.MySecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class TokenAPI {

    private MySecurityUtils mySecurityUtils;

    @PostMapping
    public String generate(@RequestBody final RequestJwtDTO requestJwtDTO) {
        return mySecurityUtils.generateJwtToken(requestJwtDTO);
    }
}
