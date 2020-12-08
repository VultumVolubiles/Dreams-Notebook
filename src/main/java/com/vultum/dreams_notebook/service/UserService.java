package com.vultum.dreams_notebook.service;

import com.vultum.dreams_notebook.dto.RoleWrapper;
import com.vultum.dreams_notebook.dto.UserWrapper;
import com.vultum.dreams_notebook.entity.Role;
import com.vultum.dreams_notebook.entity.User;
import com.vultum.dreams_notebook.repository.RoleRepository;
import com.vultum.dreams_notebook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public UserWrapper getById(Long id) {
        Assert.notNull(id, "Id is null");

        User user = repository.findOneById(id);
        Assert.notNull(user, "User not found");

        return new UserWrapper(user);
    }

    // TODO only for admins
    public UserWrapper create(UserWrapper wrapper) {
        Assert.notNull(wrapper, "User is null");

        User user = repository.findByLogin(wrapper.getLogin());
        Assert.isNull(user, "User with login \""+wrapper.getLogin()+"\" already created");

        user = new User();
        Set<Role> roles = roleRepository.findAllByNameIn(wrapper.getRoles()
                .stream()
                .map(RoleWrapper::getName)
                .collect(Collectors.toList()));
        if (roles.size() < wrapper.getRoles().size())
            throw new NullPointerException("Not all roles founded");
        user.setRoles(roles);
        wrapper.fromWrapper(user);
        user.setPassword(wrapper.getPassword());

        return new UserWrapper(repository.save(user));
    }

    public UserWrapper update(UserWrapper wrapper) {
        Assert.notNull(wrapper, "User is null");
        Assert.notNull(wrapper.getId(), "User id is null");

        User user = repository.findOneById(wrapper.getId());
        Assert.notNull(user, "User not found");

        Set<Role> roles = roleRepository.findAllByNameIn(wrapper.getRoles()
                .stream()
                .map(RoleWrapper::getName)
                .collect(Collectors.toList()));
        // TODO if old roles not equals new roles check admin role in current user
        // if admin {
        Set<String> oldRoles = wrapper.getRoles().stream().map(RoleWrapper::getName).collect(Collectors.toSet());
        Set<String> newRoles = roles.stream().map(Role::getName).collect(Collectors.toSet());
        if (!oldRoles.equals(newRoles))
            throw new NullPointerException("Not all roles founded");
        user.setRoles(roles);
        // }
        wrapper.fromWrapper(user);
        return new UserWrapper(repository.save(user));
    }

    // TODO block or deleting user
}
