package com.vultum.dreams_notebook.security;

import com.vultum.dreams_notebook.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class UserDetail implements UserDetails {
    private final Long id;
    private final String name;
    private final String login;
    private final String password;
    private final Collection<GrantedAuthority> authorities = new HashSet<>();

    public UserDetail(User user) {
        id = user.getId();
        name = user.getName();
        login = user.getLogin();
        password = user.getPassword();
        user.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getName())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
