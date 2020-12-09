package com.vultum.dreams_notebook.security;

import com.vultum.dreams_notebook.security.UserDetail;
import com.vultum.dreams_notebook.entity.User;
import com.vultum.dreams_notebook.repository.UserRepository;
import com.vultum.dreams_notebook.utils.Asserts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty())
            throw new IllegalAccessError("Username null or empty string");

        User user = repository.findByLogin(username);
        Asserts.notNull(user, "User not found");

        return new UserDetail(user);
    }
}
