package com.vultum.dreams_notebook.service;

import com.vultum.dreams_notebook.dto.NoteWrapper;
import com.vultum.dreams_notebook.dto.filter.NoteFilter;
import com.vultum.dreams_notebook.entity.Note;
import com.vultum.dreams_notebook.entity.User;
import com.vultum.dreams_notebook.repository.NoteRepository;
import com.vultum.dreams_notebook.repository.UserRepository;
import com.vultum.dreams_notebook.repository.specifications.NoteSpecification;
import com.vultum.dreams_notebook.utils.Asserts;
import com.vultum.dreams_notebook.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;
    private final UserRepository userRepository;

    public NoteWrapper get(Long id) {
        Asserts.notNull(id, "Id is null");

        Note note = repository.findOneById(id);
        Asserts.notNull(note, "Note not found");

        return new NoteWrapper(note);
    }

    public NoteWrapper create(NoteWrapper wrapper) {
        Asserts.notNull(wrapper, "Note is null");

        Note note = new Note();
        note.setDateCreate(DateUtils.nowUnix());
        note.setDateUpdate(note.getDateCreate());
        wrapper.fromWrapper(note);

        Asserts.notNull(wrapper.getAuthor(), "Author is null");
        User user = userRepository.findOneById(wrapper.getAuthor());
        Asserts.notNull(user, "User not found");
        note.setAuthor(user);

        return new NoteWrapper(repository.save(note));
    }

    public NoteWrapper update(NoteWrapper wrapper) {
        Asserts.notNull(wrapper, "Note is null");

        Note note = repository.findOneById(wrapper.getId());
        Asserts.notNull(note, "Note not found");
        wrapper.fromWrapper(note);
        note.setDateUpdate(DateUtils.nowUnix());

        return new NoteWrapper(repository.save(note));
    }

    public void delete(Long id) {
        Asserts.notNull(id, "Id is null");

        Note note = repository.findOneById(id);
        Asserts.notNull(note, "Note not found");
        repository.delete(note);
    }

    public List<NoteWrapper> search(NoteFilter filter) {
        // todo return Page<NoteWrapper>
        List<Note> notes = repository.findAll(NoteSpecification.build(filter));
        return notes.stream().map(NoteWrapper::new).collect(Collectors.toList());
    }
}
