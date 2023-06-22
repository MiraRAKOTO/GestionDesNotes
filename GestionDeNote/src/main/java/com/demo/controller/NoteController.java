package com.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Matiere;
import com.demo.entity.Note;
import com.demo.services.MatiereService;
import com.demo.services.NoteService;

@RestController
@RequestMapping("api/note") 
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value="findAllNote",method= RequestMethod.GET,produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept= application/json")
	public ResponseEntity<Iterable<Note>> findAllNote(){
		try {
			return new ResponseEntity<Iterable<Note>>(noteService.getSortASCNote(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Iterable<Note>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*@RequestMapping(value = "findByLibelle/{libelle}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Matiere>> findByNameEtudiant(@PathVariable("libelle") String libelle) {
	    try {
	        return new ResponseEntity<Iterable<Matiere>>(matiereService.findByLibelle(libelle), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Iterable<Matiere>>(HttpStatus.BAD_REQUEST);
	    }
	}*/
	
	
	@RequestMapping(value = "findByIdNote/{id}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Note> findByIdMat(@PathVariable("id") int id) {
	    try {
	        return new ResponseEntity<Note>(noteService.findByIdNote(id), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Note>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	
	 @PostMapping(value = "createNote", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	    public ResponseEntity<Note> createMatiere(@RequestBody Note note) {
	        try {
	        	System.out.println(note);
	        	noteService.saveNote(note);
	            
	            return new ResponseEntity<>(note, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 @PutMapping(value = "updateNote/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Note> updateNotee(@PathVariable("id") int id, @RequestBody Note note) {
	     try {
	         Note existingNote = noteService.findByIdNote(id);
	         if (existingNote == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	         else {
	        	 existingNote.setNote(note.getNote());
	        	 noteService.saveNote(note);


		         return new ResponseEntity<>(existingNote, HttpStatus.OK);
	        	 
	         }

	        
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @DeleteMapping(value = "deleteMat/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Void> deleteMatiere(@PathVariable("id") int id) {
	     try {
	    	  Note existingNote = noteService.findByIdNote(id);
	         if (existingNote == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         } else {
	        	 noteService.deleteNote(existingNote);
	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	         }
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }


}
