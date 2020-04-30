package org.lgs.lviv.education.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ENROLLEE, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
