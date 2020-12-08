package com.vultum.dreams_notebook.repository;

import com.vultum.dreams_notebook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    Set<Role> findAllByNameIn(List<String> names);

}
