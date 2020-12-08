package com.vultum.dreams_notebook.controller;

import com.vultum.dreams_notebook.dto.EnumWrapper;
import com.vultum.dreams_notebook.dto.NoteWrapper;
import com.vultum.dreams_notebook.dto.filter.NoteFilter;
import com.vultum.dreams_notebook.enums.NoteSortingFields;
import com.vultum.dreams_notebook.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public Page<NoteWrapper> search(@RequestBody NoteFilter filter) {
        return service.search(filter);
    }

    @GetMapping("sorting")
    public List<EnumWrapper> sortingFields() {
        return Arrays.stream(NoteSortingFields.values())
                .map(f -> new EnumWrapper(f.getName(), f.toString()))
                .collect(Collectors.toList());
    }
}
