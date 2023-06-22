package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "note")

public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNote")
	private int idNote;
    @ManyToOne
    @JoinColumn(name = "numEt")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "codeMat")
    private Matiere matiere;
    
    @Column(name="note")
    private Double note;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	
	public Note() {
		super();
	}


	public Note(Etudiant etudiant, Matiere matiere, Double note) {
		super();
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.note = note;
	}

	public Note(int idNote, Etudiant etudiant, Matiere matiere, Double note) {
		super();
		this.idNote = idNote;
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.note = note;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}
    
	@Override
    public String toString() {
        return "Note:"+note
        		+"Etudiant: "+etudiant;
    }
}

