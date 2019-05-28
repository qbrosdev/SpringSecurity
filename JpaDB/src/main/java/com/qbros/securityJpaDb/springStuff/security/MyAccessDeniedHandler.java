package com.qbros.securityJpaDb.springStuff.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
            throws IOException, ServletException {
        response.getWriter().print("You don't have required role to perform this action.");
    }
}
