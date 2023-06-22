package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.demo.entity.Etudiant;
import com.demo.entity.Note;

public interface NoteRepository extends JpaRepository<Note,Integer>{
	 
	 
}
