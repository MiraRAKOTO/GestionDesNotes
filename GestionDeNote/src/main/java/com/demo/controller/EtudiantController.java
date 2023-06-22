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

import com.demo.entity.Etudiant;
import com.demo.services.EtudiantService;

@RestController
@RequestMapping("api/etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;
	
	@RequestMapping(value="findAllEtudiant",method= RequestMethod.GET,produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers ="Accept= application/json")
	public ResponseEntity<Iterable<Etudiant>> findAllEtudiant(){
		try {
			return new ResponseEntity<Iterable<Etudiant>>(etudiantService.getAllEtudiantsAscending(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Iterable<Etudiant>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findByNameEt/{nom}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Etudiant>> findByNameEtudiant(@PathVariable("nom") String nom) {
	    try {
	        return new ResponseEntity<Iterable<Etudiant>>(etudiantService.findNomEt(nom), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Iterable<Etudiant>>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@RequestMapping(value = "findByNiveauEt/{niveau}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Etudiant>> findByNivEtudiant(@PathVariable("niveau") String niveau) {
	    try {
	        return new ResponseEntity<Iterable<Etudiant>>(etudiantService.getAllByNiveau(niveau), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Iterable<Etudiant>>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@RequestMapping(value = "findByIdEt/{id}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Etudiant> findByIdEtudiant(@PathVariable("id") int id) {
	    try {
	        return new ResponseEntity<Etudiant>(etudiantService.findByIdEt(id), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<Etudiant>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	
	 @PostMapping(value = "createEtudiant", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
	        try {
	             etudiantService.saveEt(etudiant);;
	            return new ResponseEntity<>(etudiant, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 @PutMapping(value = "updateEtudiant/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") int id, @RequestBody Etudiant etudiant) {
	     try {
	         Etudiant existingEtudiant = etudiantService.findByIdEt(id);
	         if (existingEtudiant == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	         else {
	        	 existingEtudiant.setNomEt(etudiant.getNomEt());
		         existingEtudiant.setNiveauEt(etudiant.getNiveauEt());

		         etudiantService.saveEt(existingEtudiant);

		         return new ResponseEntity<>(existingEtudiant, HttpStatus.OK);
	        	 
	         }

	        
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @DeleteMapping(value = "deleteEtudiant/{id}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public ResponseEntity<Void> deleteEtudiant(@PathVariable("id") int id) {
	     try {
	         Etudiant existingEtudiant = etudiantService.findByIdEt(id);
	         if (existingEtudiant == null) {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         } else {
	             etudiantService.deleteEt(existingEtudiant);
	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	         }
	     } catch (Exception e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }



}
