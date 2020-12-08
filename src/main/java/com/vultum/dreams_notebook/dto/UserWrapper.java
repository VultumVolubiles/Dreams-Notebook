package com.vultum.dreams_notebook.dto;

import com.vultum.dreams_notebook.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserWrapper extends Wrapper<User> {
    private Long id;
    private String login;
    private String name;
    private String password;
    private List<RoleWrapper> roles = new ArrayList<>();

    public UserWrapper() {}

    public UserWrapper(User user) {
        toWrapper(user);
    }

    @Override
    public void toWrapper(User item) {
        if (item != null) {
            id = item.getId();
            login = item.getLogin();
            name = item.getName();
            roles = item.getRoles().stream().map(RoleWrapper::new).collect(Collectors.toList());
        }
    }

    @Override
    public void fromWrapper(User item) {
        if (item != null) {
            item.setName(this.name);
        }
    }


}