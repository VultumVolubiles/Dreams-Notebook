package com.vultum.dreams_notebook.service;

import com.vultum.dreams_notebook.dto.NoteWrapper;
import com.vultum.dreams_notebook.entity.Note;
import com.vultum.dreams_notebook.entity.User;
import com.vultum.dreams_notebook.repository.NoteRepository;
import com.vultum.dreams_notebook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;
    private final UserRepository userRepository;

    public NoteWrapper get(Long id) {
        Assert.notNull(id, "Id is null");

        Note note = repository.findOneById(id);
        Assert.notNull(note, "Note not found");

        return new NoteWrapper(note);
    }

    public NoteWrapper create(NoteWrapper wrapper) {
        Assert.notNull(wrapper, "Note is null");

        Note note = new Note();
        wrapper.fromWrapper(note);

        Assert.notNull(wrapper.getAuthor(), "Author is null");
        User user = userRepository.findOneById(wrapper.getAuthor().getId());
        Assert.notNull(user, "User not found");
        note.setAuthor(user);

        return new NoteWrapper(repository.save(note));
    }

    public NoteWrapper update(NoteWrapper wrapper) {
        Assert.notNull(wrapper, "Note is null");

        Note note = repository.findOneById(wrapper.getId());
        Assert.notNull(note, "Note not found");
        wrapper.fromWrapper(note);

        return new NoteWrapper(repository.save(note));
    }

    public void delete(Long id) {
        Assert.notNull(id, "Id is null");

        Note note = repository.findOneById(id);
        Assert.notNull(note, "Note not found");
        repository.delete(note);
    }
}
