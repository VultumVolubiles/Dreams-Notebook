package com.vultum.dreams_notebook.repository;

import com.vultum.dreams_notebook.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoteRepository extends JpaRepository<Note, Long>, JpaSpecificationExecutor<Note> {
    Note findOneById(Long id);
}
