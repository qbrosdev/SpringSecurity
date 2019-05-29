package com.qbros.jwtSecurity.jwtSecurity;

import com.qbros.controller.dto.Jwt;
import com.qbros.controller.dto.RequestJwtDTO;
import com.qbros.controller.dto.JwtUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private MySecurityUtils mySecurityUtils;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        Jwt jwt = (Jwt) usernamePasswordAuthenticationToken;
        String token = jwt.getToken();

        RequestJwtDTO requestJwtDTO = mySecurityUtils.validateJwtRequest(token);

        if (requestJwtDTO == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(requestJwtDTO.getRole());
        return new JwtUserDetails(requestJwtDTO.getUserName(), requestJwtDTO.getId(), token, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (Jwt.class.isAssignableFrom(aClass));
    }
}
