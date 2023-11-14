package com.ua.notehub.controller;

import com.ua.notehub.model.Note;
import com.ua.notehub.servise.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/notes/{Id}")
    public ResponseEntity<List<Note>> getNotes(@PathVariable Long Id) {

        // Get list of user notes from NoteService
        List<Note> notes = noteService.getNotesById(Id);

        // Check whether the list of notes is not empty
        if (notes.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return the answer 204 No Content
        } else {
            return ResponseEntity.ok(notes); // Return the list of notes in the response
        }

    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {

        // Call the service to create a new note
        Note createdNote = noteService.createNote(note);

        // If the note was created successfully, return the HTTP status 201 Created and the created note in the response
        if (createdNote != null) {
            return ResponseEntity.status(201).body(createdNote);
        } else {
            // If the creation of the note was unsuccessful, we return the HTTP status 400 Bad Request
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Note id, @RequestBody Note updatedNote) {
        // Get the note ID from the URL path and the data to update from the request body
        // Call the service to update the note and pass the ID and updated data
        Note updated = noteService.updateNote(id, updatedNote);

        if (updated != null) {
            // If the note was successfully updated, return an HTTP status of 200 OK and the updated note
            return ResponseEntity.ok(updated);
        } else {
            // If the note does not exist or update is not possible, return HTTP status 400 Bad Request
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

}
