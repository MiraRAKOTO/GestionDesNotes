package entity;

import java.util.List;




public class Etudiant {
    private int numEt;
    private String nomEt;
    private String niveauEt;
    private List<Note> notes;
  
    
    
    // Autres attributs et méthodes getter/setter
    
    public Etudiant(String nomEt, String niveauEt) {
		super();
		this.nomEt = nomEt;
		this.niveauEt = niveauEt;
	}

	public Etudiant() {
        // Constructeur par défaut
    }
    
    public Etudiant(int numEt, String nomEt, String niveauEt) {
        this.numEt = numEt;
        this.nomEt = nomEt;
        this.niveauEt = niveauEt;
    }
    
    // Méthodes getter/setter pour les propriétés
    
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
    
    // Autres méthodes spécifiques à l'entité "Etudiant"
    
    @Override
    public String toString() {
        return "Etudiant{" +
                "numEt=" + numEt +
                ", nomEt='" + nomEt + '\'' +
                ", niveauEt='" + niveauEt + '\'' +
                '}';
    }
    public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
    
}
