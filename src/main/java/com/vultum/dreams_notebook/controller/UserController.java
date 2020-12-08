package com.vultum.dreams_notebook.controller;

import com.vultum.dreams_notebook.dto.UserWrapper;
import com.vultum.dreams_notebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("{id}")
    public UserWrapper get(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping("create")
    public UserWrapper create(@RequestBody UserWrapper wrapper) {
        return service.create(wrapper);
    }

    @PostMapping
    public UserWrapper update(@RequestBody UserWrapper wrapper) {
        return service.update(wrapper);
    }


}