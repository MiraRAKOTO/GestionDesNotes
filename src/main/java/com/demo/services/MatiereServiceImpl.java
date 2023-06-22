package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.Matiere;
import com.demo.repository.MatiereRepository;
@Service
public class MatiereServiceImpl implements MatiereService{
	@Autowired
	MatiereRepository matiereRepository;
	
	@Override
	public Iterable<Matiere> findAll() {
		// TODO Auto-generated method stub
		return this.matiereRepository.findAll();
	}

	@Override
	public Matiere findByIdMat(Integer id) {
		// TODO Auto-generated method stub
		return this.matiereRepository.findById(id).orElse(null);
	}

	@Override
	public void saveMat(Matiere matiere) {
		this.matiereRepository.save(matiere);
		
	}

	@Override
	public void deleteMat(Matiere matiere) {
		this.matiereRepository.delete(matiere);
		
	}

	@Override
	public Iterable<Matiere> getMatieresAscending() {
		Sort sort = Sort.by(Sort.Direction.ASC, "codeMat"); // Tri par ordre croissant sur le champ "nomEt"
        return this.matiereRepository.findAll(sort);
	}

	@Override
	public Iterable<Matiere> findByLibelle(String libelleMat) {
		// TODO Auto-generated method stub
		return this.matiereRepository.findByLibelle(libelleMat);
	}

}
