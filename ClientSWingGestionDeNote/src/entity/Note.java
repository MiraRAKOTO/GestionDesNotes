package entity;


public class Note {

	private int idNote;
    
    private Etudiant etudiant;

    private Matiere matiere;
    
    private Double note;
    

	public Note(int idNote, Etudiant etudiant, Matiere matiere, Double note) {
		super();
		this.idNote = idNote;
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.note = note;
	}

	public Note() {
		super();
	}

	public Etudiant getEtudiant() {
		return etudiant;
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
    

}

