package com.vultum.dreams_notebook.controller;

import com.vultum.dreams_notebook.dto.NoteWrapper;
import com.vultum.dreams_notebook.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @GetMapping("{id}")
    public NoteWrapper get(@RequestParam(name = "id") Long id) {
        return service.get(id);
    }

    @PostMapping("create")
    public NoteWrapper create(@RequestBody NoteWrapper wrapper) {
        return service.create(wrapper);
    }

    @PostMapping
    public NoteWrapper update(@RequestBody NoteWrapper wrapper) {
        return service.update(wrapper);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestParam(name = "id") Long id) {
        service.delete(id);
    }

    @PostMapping("search")
    public List<NoteWrapper> search() {
//        return service.search(filter); todo
        return null;
    }
}
