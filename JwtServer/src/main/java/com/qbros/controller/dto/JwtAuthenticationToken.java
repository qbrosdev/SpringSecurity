package com.qbros.controller.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Data
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
