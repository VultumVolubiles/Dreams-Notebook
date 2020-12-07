package com.vultum.dreams_notebook.dto;

import com.vultum.dreams_notebook.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleWrapper extends Wrapper<Role> {
    private String name;

    public RoleWrapper() {}

    public RoleWrapper(Role role) {
        toWrapper(role);
    }

    @Override
    public void toWrapper(Role item) {
        if (item != null) {
            name = item.getName();
        }
    }

    @Override
    public void fromWrapper(Role item) {
        if (item != null) {
            item.setName(name);
        }
    }


}
