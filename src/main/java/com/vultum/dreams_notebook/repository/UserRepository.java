package com.vultum.dreams_notebook.repository;

import com.vultum.dreams_notebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);

    User findByLogin(String login);


}
