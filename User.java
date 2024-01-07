package core;

public class User {
	
	private String prenom;
	private String nom;
	private String adressePostale;
	private long numTel;
	private String adresseEmail;
	private String numCarteIdentite;
	private long numCompteBancaire;
	private String identifiant;
	private String motDePasse;
	
	public User (String prenom, String nom, String adressePostale, long numTel, String adresseEmail, String numCarteIdentite, long numCompteBancaire, String identifiant, String motDePasse) {
		this.prenom=prenom; this.nom=nom; this.adressePostale=adressePostale;
		this.numTel=numTel; this.adresseEmail=adresseEmail; this.numCarteIdentite=numCarteIdentite;
		this.numCompteBancaire=numCompteBancaire; this.identifiant=identifiant; this.motDePasse=motDePasse;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public String getAdressePostale() {
		return this.adressePostale;
	}
	public void setAdressePostale(String adresse) {
		this.adressePostale=adresse;
	}
	public long getNumTel() {
		return this.numTel;
	}
	public void setNumTel(int numero) {
		this.numTel=numero;
	}
	public String getAdresseEmail() {
		return this.adresseEmail;
	}
	public void setAdresseEmail(String adresse) {
		this.adresseEmail=adresse;
	}
	public String getNumCarteIdentite() {
		return this.numCarteIdentite;
	}
	public void setNumCarteIdentite(String numero) {
		this.numCarteIdentite=numero;
	}
	public long getNumCompteBancaire() {
		return this.numCompteBancaire;
	}
	public void setNumCompteBancaire(long numero) {
		this.numCompteBancaire=numero;
	}
	public String getIdentifiant() {
		return this.identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant=identifiant;
	}
	public String getMotDePasse() {
		return this.motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse=motDePasse;
	}
	
	@Override 
	public String toString() {
		return  "{Prénom : "+this.prenom+
				", Nom : "+this.nom+
				", L'adresse postale : "+this.adressePostale+
				", numéro de téléphone : "+this.numTel+
				", L'adresse E-mail : "+this.adresseEmail+
				", CNI : "+this.numCarteIdentite+
				", Numéro compte bancaire : "+this.numCompteBancaire+
				", L'identifiant : "+this.identifiant+
				", Le mot de passe : "+this.motDePasse+"}";
	}
	
	
}
