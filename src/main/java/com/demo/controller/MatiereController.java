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

import com.demo.services.MatiereService;

@RestController
@RequestMapping("api/matiere") 
public class MatiereController {
	
	@Autowired
	private MatiereService matiereService;
	
	@RequestMapping(value="findAllMatiere",method= RequestMethod.GET,produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept= application/json")
	public ResponseEntity<Iterable<Matiere>> findAllMatiere(){
		try {
			return new ResponseEntity<Iterable<Matiere>>(matiereService.getMatieresAscending(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Iterable<Matiere>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findByLibelle/{libelle}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Matiere>> findByNameEtudiant(@PathVariable("libelle") String libelle) {
	    try {
	        return new ResponseEntity<Iterable<Matiere>>(matiereService.findByLibelle(libelle), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Iterable<Matiere>>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	@RequestMapping(value = "findByIdMat/{id}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Matiere> findByIdMat(@PathVariable("id") int id) {
	    try {
	        return new ResponseEntity<Matiere>(matiereService.findByIdMat(id), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Matiere>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	
	 @PostMapping(value = "createMatiere", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	    public ResponseEntity<Matiere> createMatiere(@RequestBody Matiere mat) {
	        try {
	             matiereService.saveMat(mat);;
	            return new ResponseEntity<>(mat, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 @PutMapping(value = "updateMatiere/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Matiere> updateMatiere(@PathVariable("id") int id, @RequestBody Matiere mat) {
	     try {
	         Matiere existingMatiere = matiereService.findByIdMat(id);
	         if (existingMatiere == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	         else {
	        	 existingMatiere.setLibelleMat(mat.getLibelleMat());
	        	 existingMatiere.setCoefMat(mat.getCoefMat());
		     matiereService.saveMat(existingMatiere);


		         return new ResponseEntity<>(existingMatiere, HttpStatus.OK);
	        	 
	         }

	        
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @DeleteMapping(value = "deleteMat/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Void> deleteMatiere(@PathVariable("id") int id) {
	     try {
	    	 Matiere existingMatiere = matiereService.findByIdMat(id);
	         if (existingMatiere == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         } else {
	             matiereService.deleteMat(existingMatiere);
	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	         }
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }


}
