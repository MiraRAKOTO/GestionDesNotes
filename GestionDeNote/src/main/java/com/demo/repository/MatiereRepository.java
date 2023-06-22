package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Etudiant;
import com.demo.entity.Matiere;
@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Integer>{
	 @Query("SELECT m FROM Matiere m WHERE m.libelleMat LIKE %:name%")
	   Iterable <Matiere> findByLibelle(@Param("name") String name);
	 
}
