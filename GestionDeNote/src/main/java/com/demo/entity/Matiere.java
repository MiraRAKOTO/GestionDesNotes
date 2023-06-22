package com.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="matiere")
public class Matiere implements Serializable {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codeMat")
	private int codeMat;
	
	@Column(name="libelleMat")
	private String libelleMat;
	
	@Column(name="coefMat")
	private Double coefMat;
	
	 @OneToMany(fetch = FetchType.EAGER,mappedBy = "matiere")
	 private List<Note> notes;
	 
	 

	public Matiere() {
		super();
	}

	public int getCodeMat() {
		return codeMat;
	}

	public void setCodeMat(int codeMat) {
		this.codeMat = codeMat;
	}

	public String getLibelleMat() {
		return libelleMat;
	}

	public void setLibelleMat(String libelleMat) {
		this.libelleMat = libelleMat;
	}

	public Double getCoefMat() {
		return coefMat;
	}

	public void setCoefMat(Double coefMat) {
		this.coefMat = coefMat;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
        return "Matiere{" +
                "codeMat=" + codeMat +
                ", libelleMat='" + libelleMat + '\'' +
                ", notes='" +  notes + '\'' +
                '}';
	}

}
