package core;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

public class mainView extends Application {
	
	private String[] session = Session.getutilisateurConnecte();
	private SimpleStringProperty employeeCountProperty = new SimpleStringProperty("Vous avez 0 employés");
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Path cheminIcone = Paths.get("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\icone.png");
		File iconeFile = cheminIcone.toFile();
		if (iconeFile.exists()) {
		    String iconePath = iconeFile.toURI().toString();
		    Image icon = new Image(iconePath);
		    stage.getIcons().add(icon);
		} else {
		    System.err.println("Resource not found: " + iconeFile.getAbsolutePath());
		}
		
		Text welcome = new Text("Bienvenue "+session[0]);
		
		Button btnProfil = new Button("Votre Profile");
		btnProfil.setOnMouseClicked((evt)->{
			profilView profil = new profilView();
			try { profil.start(new Stage()); }
			catch (Exception e) { e.printStackTrace(); }
		});
		
		Button btnDeconnect = new Button("Se déconnecter");
		btnDeconnect.setOnMouseClicked((evt)->{
			stage.close();
			loginView login = new loginView();
			try {
				login.start(new Stage());
			}
			catch (Exception e) { e.printStackTrace(); }
		});
		
		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(10);
		vbox1.getChildren().addAll(welcome,btnProfil,btnDeconnect);
		
		Text nbrProjects = new Text("Vous avez 0 projets");
		Button btnAllProjects = new Button("Tous les projets");
		Button btnNewProject = new Button("Nouveau projet");
		HBox hbox1 = new HBox();
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(10);
		hbox1.getChildren().addAll(btnAllProjects,btnNewProject);
		
		VBox vbox2 = new VBox();
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setSpacing(10);
		vbox2.getChildren().addAll(nbrProjects,hbox1);
		
		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setSpacing(50);
		hbox2.getChildren().addAll(vbox1,vbox2);
		
		TableView<Tache> tableView = new TableView<>();
		tableView.setMinSize(450, 200);
		tableView.setPrefSize(450, 200);
		tableView.setMaxSize(450, 200);
		tableView.setEditable(true);
		
		Responsable respo = new Responsable("Oussama","OUZAKRI","04 LOT EL HANAE",0761,"oussamaouzakri@gmail.com","J951426",789654123,"oussama","oussa3002");
		Projet projet = new Projet(147,"projet 1",status.EN_COURS,respo,new ArrayList<Tache>());
		ObservableList<Tache> list = FXCollections.observableArrayList(
					new Tache(81456293,"tache 1","description 1",projet),
					new Tache(95138742,"tache 2","description 2",projet),
					new Tache(76329483,"tache 3","description 3",projet)
				);
		
		TableColumn<Tache, String> designation = new TableColumn<>("Désignation de la tâche");
		designation.setMinWidth(100);
		designation.setPrefWidth(150);
		designation.setMaxWidth(200);
		designation.setCellValueFactory(new PropertyValueFactory<Tache,String>("description"));
		
		TableColumn<Tache, Date> debut = new TableColumn<>("Début");
		debut.setMinWidth(100);
		debut.setPrefWidth(150);
		debut.setMaxWidth(200);
		debut.setCellValueFactory(new PropertyValueFactory<Tache,Date>("dateDebut"));
		
		TableColumn<Tache, Date> fin = new TableColumn<>("Fin");
		fin.setMinWidth(100);
		fin.setPrefWidth(150);
		fin.setMaxWidth(200);
		fin.setCellValueFactory(new PropertyValueFactory<Tache,Date>("dateFin"));
		
		tableView.setItems(list);
		tableView.getColumns().addAll(designation,debut,fin);
		
		TableView<Intervenant> tableIntervenant = new TableView<>();
		tableIntervenant.setMinSize(225, 200);
		tableIntervenant.setPrefSize(225, 200);
		tableIntervenant.setMaxSize(225, 200);
		tableIntervenant.setEditable(true);
		
		ObservableList<Intervenant> intervenant = FXCollections.observableArrayList(
				);
		
		TableColumn<Intervenant,Integer> id = new TableColumn<>("ID");
		id.setMinWidth(50);
		id.setPrefWidth(75);
		id.setMaxWidth(100);
		id.setCellValueFactory(new PropertyValueFactory<Intervenant,Integer>("id"));
		
		TableColumn<Intervenant, String> nom = new TableColumn<>("Nom");
		nom.setMinWidth(50);
		nom.setPrefWidth(75);
		nom.setMaxWidth(100);
		nom.setCellValueFactory(new PropertyValueFactory<Intervenant,String>("nom"));
		
		TableColumn<Intervenant, String> prenom = new TableColumn<>("Prénom");
		prenom.setMinWidth(50);
		prenom.setPrefWidth(75);
		prenom.setMaxWidth(100);
		prenom.setCellValueFactory(new PropertyValueFactory<Intervenant,String>("prenom"));
		
		tableIntervenant.setItems(intervenant);
		tableIntervenant.getColumns().addAll(id,nom,prenom);
		
		Label employes = new Label("Employés");
		Label nbrEmployes = new Label();
		nbrEmployes.textProperty().bind(employeeCountProperty);
		Button ajouterEmploye = new Button(" Ajouter un employé ");
		ajouterEmploye.setOnMouseClicked((evt)->{
			AddIntervenant addEmployee = new AddIntervenant();
			try { addEmployee.start(new Stage()); }
			catch (Exception e) {e.printStackTrace(); }
			Intervenant newEmployee = addEmployee.getNewEmployee();
			intervenant.add(newEmployee);
			employeeCountProperty.set("Vous avez " + intervenant.size() + " employés");
		});
		VBox vbox4 = new VBox();
		vbox4.setAlignment(Pos.CENTER);
		vbox4.setSpacing(10);
		vbox4.getChildren().addAll(employes,nbrEmployes,tableIntervenant,ajouterEmploye);
		
		TableView<Materiel> tableMateriel = new TableView<>();
		tableMateriel.setMinSize(225, 200);
		tableMateriel.setPrefSize(225, 200);
		tableMateriel.setMaxSize(225, 200);
		tableMateriel.setEditable(true);
		
		ObservableList<Materiel> materiels = FXCollections.observableArrayList(
				new Materiel(1,"materiel 1","type de matériel 1",respo),
				new Materiel(2,"materiel 2","type de matériel 2",respo),
				new Materiel(3,"materiel 3","type de matériel 3",respo)
			);

		TableColumn<Materiel,Integer> idMateriel = new TableColumn<>("ID");
		idMateriel.setMinWidth(50);
		idMateriel.setPrefWidth(75);
		idMateriel.setMaxWidth(100);
		idMateriel.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("identifiant"));
		
		TableColumn<Materiel, String> title = new TableColumn<>("Title");
		title.setMinWidth(50);
		title.setPrefWidth(75);
		title.setMaxWidth(100);
		title.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nomMateriel"));
		
		TableColumn<Materiel, String> description = new TableColumn<>("Désignation");
		description.setMinWidth(50);
		description.setPrefWidth(75);
		description.setMaxWidth(100);
		description.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
		
		tableMateriel.setItems(materiels);
		tableMateriel.getColumns().addAll(idMateriel,title,description);

		Label materiel = new Label("Matériaux");
		Label nbrMateriel = new Label("Vous avez "+materiels.size()+" matériaux");
		Button ajouterMateriel = new Button(" Ajouter un matériel ");
		
		
		VBox vbox5 = new VBox();
		vbox5.setAlignment(Pos.CENTER);
		vbox5.setSpacing(10);
		vbox5.getChildren().addAll(materiel,nbrMateriel,tableMateriel,ajouterMateriel);
		
		HBox hbox5 = new HBox();
		hbox5.setAlignment(Pos.CENTER);
		hbox5.setSpacing(10);
		hbox5.getChildren().addAll(vbox4,vbox5);
		
		VBox vbox3 = new VBox();
		VBox.setVgrow(tableView, Priority.ALWAYS);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setSpacing(10);
		vbox3.getChildren().addAll(hbox2,tableView,hbox5);
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox3.setBackground(background);
		
		Scene scene = new Scene(vbox3);
		stage.setScene(scene);
		stage.setTitle("ExecuSync Projects - Accueil");
		stage.setHeight(700);
		stage.setWidth(800);
		stage.show();
	}
	public static void main(String[] args) {
        launch();
    }
}
