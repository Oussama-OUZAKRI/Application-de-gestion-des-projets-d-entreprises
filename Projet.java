package core;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Projet {
	
	private long identifiant;
	private String nomProjet;
	private Date dateDebut = new Date();
	private Date dateFin=null;
	private status stat;
	private Responsable responsable;
	private List<Tache> taches = new ArrayList<>();
	
	@JsonCreator
    public Projet(
            @JsonProperty("identifiant") long identifiant,
            @JsonProperty("nomProjet") String nomProjet,
            @JsonProperty("status") status status,
            @JsonProperty("responsable") Responsable responsable,
            @JsonProperty("taches") List<Tache> taches) {
        this.identifiant = identifiant;
        this.nomProjet = nomProjet;
        this.stat = status;
        this.responsable = responsable;
        this.taches = taches;
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
		return this.stat;
	}
	public void setStatus(status status) {
		this.stat=status;
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
	
    public String toJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public void saveToJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), this);
    }

    public static Projet fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Projet.class);
    }

    public static Projet loadFromJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), Projet.class);
    }
    /*
    public static void main(String[] args) throws IOException {
    	
		Responsable respo = new Responsable("Oussama","OUZAKRI","04 LOT EL HANAE",0761,"oussamaouzakri@gmail.com","J951426",789654123,"oussama","oussa3002");
        Projet myProject = new Projet(147,"projet 1",status.EN_COURS,respo,new ArrayList<Tache>());

        String jsonString = myProject.toJson();
        System.out.println("Projet en JSON : " + jsonString);

        myProject.saveToJsonFile("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\monprojet.json");

        Projet loadedProject = Projet.loadFromJsonFile("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\monprojet.json");
        if (loadedProject != null) {
            System.out.println("Projet chargé : " + loadedProject.getNomProjet());
        }
    }*/
    
}
