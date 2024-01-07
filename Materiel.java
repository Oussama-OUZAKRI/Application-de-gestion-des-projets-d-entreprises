package core;
import java.util.ArrayList;
import java.util.List;

public class Materiel {
	
	private long identifiant;
	private String nomMateriel;
	private String type;
	private List<Tache> taches = new ArrayList<>();
	private Responsable responsable;
	
	public Materiel(long identifiant, String nom, String type, Responsable responsable) {
		this.identifiant=identifiant;
		this.nomMateriel=nom; this.type=type;
		this.responsable=responsable;
	}
	
	public long getIdentifiant() {
		return this.identifiant;
	}
	public void setIdentifiant(long id) {
		this.identifiant=id;
	}
	public String getNom() {
		return this.nomMateriel;
	}
	public void setNom(String nom) {
		this.nomMateriel=nom;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public List<Tache> getTaches() {
		return this.taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches=taches;
	}
	public Responsable getResponsable() {
		return this.responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable=responsable;
	}
}
