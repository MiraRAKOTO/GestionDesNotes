package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.demo.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
	 @Query("SELECT e FROM Etudiant e WHERE e.nomEt LIKE %:name%")
	   Iterable <Etudiant> findByNameEtudiant(@Param("name") String name);
	 
	 @Query("SELECT e FROM Etudiant e WHERE e.niveauEt = :name")
	   Iterable <Etudiant> findByNiveauEtudiant(@Param("name") String name);
	 
	 
}
