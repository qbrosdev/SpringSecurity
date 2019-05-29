package com.qbros.securityJpaDb.persistance.entities.security;

import org.springframework.security.core.GrantedAuthority;

import static com.qbros.securityJpaDb.persistance.entities.security.Role.Code.ADMIN_STR;
import static com.qbros.securityJpaDb.persistance.entities.security.Role.Code.USER_STR;
import static com.qbros.securityJpaDb.persistance.entities.security.Role.Code.VIEWER_STR;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

//https://stackoverflow.com/a/54713712/3593084
public enum Role implements GrantedAuthority {
    ADMIN(ADMIN_STR),
    USER(USER_STR),
    VIEWER(VIEWER_STR);

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + roleName;
    }

    public class Code {
        public static final String ADMIN_STR = "ADMIN";
        public static final String USER_STR = "USER";
        public static final String VIEWER_STR = "VIEWER";

    }
}
