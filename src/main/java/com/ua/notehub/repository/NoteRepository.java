package com.ua.notehub.repository;

import com.ua.notehub.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> getNotesById(Long Id);

    List<Note> findByUserId(Long id);
}
