package com.qbros.jwtSecurity.jwtSecurity;

import com.qbros.controller.dto.JwtRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Component
public class MySecurityUtils {

    private String secret = "youtube";

    public JwtRequest validateJwtRequest(String token) {

        JwtRequest jwtRequest = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtRequest = new JwtRequest();
            jwtRequest.setUserName(body.getSubject());
            jwtRequest.setId(Long.parseLong((String) body.get("userId")));
            jwtRequest.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtRequest;
    }

    public String generateJwtToken(JwtRequest jwtRequest) {

        Claims claims = Jwts.claims()
                .setSubject(jwtRequest.getUserName());
        claims.put("userId", String.valueOf(jwtRequest.getId()));
        claims.put("role", jwtRequest.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
