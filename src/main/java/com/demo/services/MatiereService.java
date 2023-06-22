package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.entity.Matiere;

public interface MatiereService {
	public Iterable<Matiere> findAll();
	public Matiere findByIdMat(Integer id);
	public void saveMat(Matiere matiere);
	public void deleteMat(Matiere matiere);
	public Iterable<Matiere> getMatieresAscending();
	public Iterable<Matiere> findByLibelle(String libelleMat);
	

}
