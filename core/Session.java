package core;

public class Session {
	private static String[] utilisateurConnecte;
	
	public static String[] getutilisateurConnecte() {
		return utilisateurConnecte;
	}
	
	public static void setutilisateurConnecte(String[] utilisateur) {
		utilisateurConnecte = utilisateur;
	}
}
