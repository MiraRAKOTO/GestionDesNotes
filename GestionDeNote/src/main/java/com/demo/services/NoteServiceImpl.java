package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.Note;
import com.demo.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository noteRepository;
	@Override
	public Iterable<Note> findAllNote() {
		// TODO Auto-generated method stub
		return this.noteRepository.findAll();
	}

	@Override
	public Note findByIdNote(int id) {
		// TODO Auto-generated method stub
		return this.noteRepository.findById(id).orElse(null);
	}

	@Override
	public void saveNote(Note note) {
		// TODO Auto-generated method stub
		this.noteRepository.save(note);
	}

	@Override
	public void deleteNote(Note note) {
		// TODO Auto-generated method stub
		this.noteRepository.delete(note);
	}

	@Override
	public Iterable<Note> getSortASCNote() {
		Sort sort = Sort.by(Sort.Direction.ASC, "idNote"); // Tri par ordre croissant sur le champ "nomEt"
        return this.noteRepository.findAll(sort);
	}

}
