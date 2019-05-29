package com.qbros.jwtSecurity.jwtSecurity;

import com.qbros.controller.dto.RequestJwtDTO;
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

    private final String secret = "mySecret";

    public RequestJwtDTO validateJwtRequest(String token) {

        RequestJwtDTO requestJwtDTO = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            requestJwtDTO = new RequestJwtDTO();
            requestJwtDTO.setUserName(body.getSubject());
            requestJwtDTO.setId(Long.parseLong((String) body.get("userId")));
            requestJwtDTO.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return requestJwtDTO;
    }

    public String generateJwtToken(RequestJwtDTO requestJwtDTO) {

        Claims claims = Jwts.claims()
                .setSubject(requestJwtDTO.getUserName());
        claims.put("userId", String.valueOf(requestJwtDTO.getId()));
        claims.put("role", requestJwtDTO.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
