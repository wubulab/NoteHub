package com.ua.notehub.repository;

import com.ua.notehub.model.Note;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByUserId(Long userId);
}
