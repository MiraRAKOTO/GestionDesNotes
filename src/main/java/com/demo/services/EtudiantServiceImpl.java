package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.demo.entity.Etudiant;
import com.demo.repository.EtudiantRepository;



@Service
public class EtudiantServiceImpl implements EtudiantService{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	@Override
	public Iterable<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}


	@Override
	public Etudiant findByIdEt(Integer id) {
		// TODO Auto-generated method stub
		return this.etudiantRepository.findById(id).orElse(null);
	}


	@Override
	public void saveEt(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantRepository.save(etudiant);
		
	}


	@Override
	public void deleteEt(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantRepository.delete(etudiant);;
	}


	@Override
	public Iterable<Etudiant> getAllEtudiantsAscending() {
		Sort sort = Sort.by(Sort.Direction.ASC, "numEt"); // Tri par ordre croissant sur le champ "nomEt"
        return etudiantRepository.findAll(sort);
	}


	@Override
	public Iterable<Etudiant> findNomEt(String nomEt) {
		// TODO Auto-generated method stub
		return this.etudiantRepository.findByNameEtudiant(nomEt);
	}


	@Override
	public Iterable<Etudiant> getAllByNiveau(String niveauEt) {
		// TODO Auto-generated method stub
		return this.etudiantRepository.findByNiveauEtudiant(niveauEt);
	}
}
