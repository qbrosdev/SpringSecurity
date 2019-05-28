package com.qbros.securityJpaDb.persistance.entities.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

//https://stackoverflow.com/a/54713712/3593084
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    VIEWER("ROLE_VIEWER");

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public class Code {
        public static final String ADMIN_STR = "ADMIN";
        public static final String USER_STR = "USER";
        public static final String VIEWER_STR = "VIEWER";

    }
}
