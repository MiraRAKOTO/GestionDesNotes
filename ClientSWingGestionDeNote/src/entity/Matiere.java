package entity;

import java.util.List;



public class Matiere {

	private int codeMat;

	private String libelleMat;
	
	private Double coefMat;
	
	 private List<Note> notes;

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
	

}
