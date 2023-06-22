package com.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numEt")
    private int numEt;
    
    @Column(name = "nomEt")
    private String nomEt;
    
    @Column(name = "niveauEt")
    private String niveauEt;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "etudiant")
    private List<Note> notes;
    
    
    public Etudiant() {
		super();
	}

	public int getNumEt() {
        return numEt;
    }
    
    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }
    
    public String getNomEt() {
        return nomEt;
    }
    
    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }
    
    public String getNiveauEt() {
        return niveauEt;
    }
    
    public void setNiveauEt(String niveauEt) {
        this.niveauEt = niveauEt;
    }

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
    

}
