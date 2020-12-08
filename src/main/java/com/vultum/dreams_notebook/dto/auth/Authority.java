package com.vultum.dreams_notebook.dto.auth;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private final String role;

    public Authority(String role) {
        this.role = role;
    }
    @Override
    public String getAuthority() {
        return role;
    }
}
