package com.ua.notehub.service;

import com.ua.notehub.model.Note;
import com.ua.notehub.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getNotesById(Long Id) {
        return noteRepository.findByUserId(Id);
    }

        public Note createNote(Note note) {
        // Get the current date and time in LocalDateTime format
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Set the created date and time in the note
        note.setCreatedDate(currentDateTime);

        // Save the note in the database
        return noteRepository.save(note);
    }

    public Note updateNote(Note updatedNote, Note note) {
        // Get the original note from the database by its ID
        Note originalNote = noteRepository.findById(updatedNote.getId()).orElse(null);

        if (originalNote == null) {
            throw new RuntimeException("Note with id " + updatedNote.getId() + " not found");
        }

        // Update the fields of the original note with the values from the updated note
        originalNote.setTitle(updatedNote.getTitle());
        originalNote.setContent(updatedNote.getContent());
        originalNote.setBoardColumnName(updatedNote.getBoardColumnName());

        // Save the updated note to the database
        return noteRepository.save(originalNote);
    }

    public void deleteNote(Long id) {
        // Delete a note from the database by its identifier
        noteRepository.deleteById(id);
    }
}
