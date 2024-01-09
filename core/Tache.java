package core;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tache {
	
	private long identifiant;
	private String nomTache;
	private String description;
	private Date dateDebut = new Date();
	private Date dateFin=null;
	private List<Materiel> materiels = new ArrayList<>();
	private List<Intervenant> intervenants = new ArrayList<>();
	private Projet projet;
	
	public Tache(long identifiant, String nom, String description, Projet projet) {
		this.identifiant=identifiant; this.nomTache=nom;
		this.description=description; this.projet=projet;
	}
	
	public long getIdentifiant() {
		return this.identifiant;
	}
	public void setIdentifiant(long id) {
		this.identifiant=id;
	}
	public String getNom() {
		return this.nomTache;
	}
	public void setNom(String nom) {
		this.nomTache=nom;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public Date getDateDebut() {
		return this.dateDebut;
	}
	public void setDateDebut(Date date) {
		this.dateDebut=date;
	}
	public Date getDateFin() {
		return this.dateFin;
	}
	public void setDateFin(Date date) {
		this.dateFin=date;
	}
	public List<Materiel> getMateriels() {
		return this.materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels=materiels;
	}
	public List<Intervenant> getIntervenants() {
		return this.intervenants;
	}
	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants=intervenants;
	}
	public Projet getProjet() {
		return this.projet;
	}
	public void setProjets(Projet projet) {
		this.projet=projet;
	}
}
