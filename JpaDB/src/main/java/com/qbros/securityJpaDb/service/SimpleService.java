package com.qbros.securityJpaDb.service;


import com.qbros.securityJpaDb.persistance.entities.security.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@Service
public class SimpleService {

    @Secured({Role.Code.ADMIN_STR,Role.Code.USER_STR})
    public String test1() {
        return "test secure (Admin/ user allowed)";
    }

    @PreAuthorize(Role.Code.ADMIN_STR)
    public String test2() {

        return "test secure (Just admin allowed)";
    }

    @RolesAllowed({Role.Code.ADMIN_STR,Role.Code.USER_STR,Role.Code.VIEWER_STR})
    public String test3() {
        return "test secure (ALL roles allowed)";
    }
}
