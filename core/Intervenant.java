package core;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Intervenant extends User {
	
	private static int count=0;
	private IntegerProperty id = new SimpleIntegerProperty();
	private boolean estIntervenant=true;
	private List<Tache> taches = new ArrayList<>();
	
	public Intervenant(String prenom, String nom, String adressePostale, long numTel, String adresseEmail, String numCarteIdentite, long numCompteBancaire, String identifiant, String motDePasse) {
		super(prenom, nom, adressePostale, numTel, adresseEmail, numCarteIdentite, numCompteBancaire, identifiant, motDePasse);
		this.id.set(++count);
	}
	
	
	public int getId() {
	    return this.id.get();
	}
	public boolean getestIntervenant() {
		return this.estIntervenant;
	}
	public List<Tache> getTaches() {
		return this.taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches=taches;
	}
}
