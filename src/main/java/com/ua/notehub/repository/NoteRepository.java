package com.ua.notehub.repository;

import com.ua.notehub.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NoteRepository extends PagingAndSortingRepository<Note, String> {
    List<Note> findByUserId(Long userId);
}