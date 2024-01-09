package core;
import java.util.List;
import java.util.ArrayList;

public class Responsable extends User {
	
	private boolean estResponsable=true;
	private List<Projet> projets = new ArrayList<>();
	private List<Materiel> materiels = new ArrayList<>();
	
	public Responsable() {}
	public Responsable(String prenom, String nom, String adressePostale, long numTel, String adresseEmail, String numCarteIdentite, long numCompteBancaire, String identifiant, String motDePasse) {
		super(prenom, nom, adressePostale, numTel, adresseEmail, numCarteIdentite, numCompteBancaire, identifiant, motDePasse);
	}
	
	public boolean getEstResponsable() {
		return this.estResponsable;
	}
	public List<Projet> getProjets() {
		return this.projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets=projets;
	}
	public List<Materiel> getMateriels() {
		return this.materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels=materiels;
	}
	
}
