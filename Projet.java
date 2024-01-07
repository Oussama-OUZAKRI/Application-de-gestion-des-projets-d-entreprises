package core;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projet {
	
	private long identifiant;
	private String nomProjet;
	private Date dateDebut = new Date();
	private Date dateFin=null;
	private status status;
	private Responsable responsable;
	private List<Tache> taches = new ArrayList<>();
	
	public Projet(long identifiant, String nom, status status, Responsable responsable, List<Tache> taches) {
		this.identifiant=identifiant; this.nomProjet=nom; this.status=status;
		this.responsable=responsable; this.taches=taches;
	}
	
	public long getIdentifiant() {
		return this.identifiant;
	}
	public void setIdentifiant(long id) {
		this.identifiant=id;
	}
	public String getNomProjet() {
		return this.nomProjet;
	}
	public void setNomProjet(String nom) {
		this.nomProjet=nom;
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
	public status getStatus() {
		return this.status;
	}
	public void setStatus(status status) {
		this.status=status;
	}
	public Responsable getResponsable() {
		return this.responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable=responsable;
	}
	public List<Tache> getTaches() {
		return this.taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches=taches;
	}
	
}
