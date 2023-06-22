package com.demo.services;

import com.demo.entity.Note;

public interface NoteService {
	Iterable<Note> findAllNote();
    Note findByIdNote(int id);
    void saveNote(Note note);
    void deleteNote(Note note);
    Iterable<Note> getSortASCNote();

}
