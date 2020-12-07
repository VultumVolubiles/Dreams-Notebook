package com.vultum.dreams_notebook.repository;

import com.vultum.dreams_notebook.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
