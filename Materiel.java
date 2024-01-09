package core;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class Materiel {
	
	private long identifiant;
	private final SimpleStringProperty nomMateriel = new SimpleStringProperty();
	private String type;
	private List<Tache> taches = new ArrayList<>();
	private Responsable responsable;
	
	public Materiel() {}
	public Materiel(long identifiant, String nom, String type, Responsable responsable) {
		this.identifiant=identifiant;
		nomMateriel.set(nom);; this.type=type;
		this.responsable=responsable;
	}
	
	public long getIdentifiant() {
		return this.identifiant;
	}
	public void setIdentifiant(long id) {
		this.identifiant=id;
	}
	public String getNomMateriel() {
        return nomMateriel.get();
    }
    public void setNomMateriel(String nom) {
        nomMateriel.set(nom);
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
