package com.qbros.jwtSecurity.jwtSecurity;

import com.qbros.controller.dto.JwtAuthenticationToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SECURE_URI_REGEX = "/secure/**";
    public static final String  AUTHORIZATION_TOKEN_MARKER= "Bearer ";
    public static final String  AUTHORIZATION_EXCEPTION_MISSING_TOKEN= "JWT Token is missing";

    public JwtAuthenticationFilter() {
        super(SECURE_URI_REGEX);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith(AUTHORIZATION_TOKEN_MARKER)) {
            throw new RuntimeException(AUTHORIZATION_EXCEPTION_MISSING_TOKEN);
        }
        //fixme https://github.com/qbrosdev/EJB_Skeletal/blob/master/EJB_HTTP_EndPoint/src/main/java/com/qbros/Shiro/Filter/TokenAuthzFilter.java
        String authenticationToken = header.substring(AUTHORIZATION_TOKEN_MARKER.length());
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        //todo add some loging
    }
}
