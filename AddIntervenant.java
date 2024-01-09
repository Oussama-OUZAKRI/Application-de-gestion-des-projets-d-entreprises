package core;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddIntervenant extends Application {
	
	private Intervenant newEmployee;
	
	public Intervenant getNewEmployee () {
		return this.newEmployee;
	}
	
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
		
		Text ajouterText = new Text("Ajouter un employé");
		
		Label prenom = new Label("Prénom");
		TextField prenomField = new TextField();
		prenomField.setPrefWidth(200);
		
		Label nom = new Label("Nom");
		TextField nomField = new TextField();
		
		Label adressePostale = new Label("Adresse Postale");
		TextField adressePostaleField = new TextField();
		
		Label numTel = new Label("Numéro de Téléphone");
		TextField numTelField = new TextField();
		
		Label adresseEmail = new Label("Adresse Email");
		TextField adresseEmailField = new TextField();
		
		Label numCarteIdentite = new Label("N° Carte d'identité");
		TextField numCarteIdentiteField = new TextField();
		
		Label numCompteBancaire = new Label("N° Compte Bancaire");
		TextField numCompteBancaireField = new TextField();
		
		Label identifiant = new Label("Identifiant");
		TextField identifiantField = new TextField();
		
		
		Label motDePasse = new Label("Mot De Passe");
		TextField motDePasseField = new TextField();
		
		GridPane grpane = new GridPane();
		grpane.addRow(0, nom, nomField);
		grpane.addRow(1, prenom, prenomField);
		grpane.addRow(2, identifiant, identifiantField);
		grpane.addRow(3, motDePasse, motDePasseField);
		grpane.addRow(4, adressePostale, adressePostaleField);
		grpane.addRow(5, numTel, numTelField);
		grpane.addRow(6, adresseEmail, adresseEmailField);
		grpane.addRow(7, numCarteIdentite, numCarteIdentiteField);
		grpane.addRow(8, numCompteBancaire, numCompteBancaireField);
		grpane.setAlignment(Pos.CENTER);
		grpane.setVgap(20);
		grpane.setHgap(20);
		
		Button ajouterBtn = new Button("Ajouter");
		ajouterBtn.setOnMouseClicked((evt)->{
			String firstName = prenomField.getText();
			String lastName = nomField.getText();
			String adress = adressePostaleField.getText(); 
			long tel = Long.parseLong(numTelField.getText());
			String mail = adresseEmailField.getText();
			String CIN = numCarteIdentiteField.getText(); 
			long cptbancaire = Long.parseLong(numCompteBancaireField.getText());
			String id = identifiantField.getText();
			String passwd = motDePasseField.getText();
			this.newEmployee = new Intervenant(firstName, lastName, adress, tel, mail, CIN,
					cptbancaire, id, passwd);
			stage.close();
		});
		
		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(50);
		vbox1.getChildren().addAll(ajouterText,grpane,ajouterBtn);
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox1.setBackground(background);
		
		Scene scene = new Scene(vbox1);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("ExecuSync Projects - Profil");
		stage.setHeight(700);
		stage.setWidth(400);
		stage.showAndWait();
		
	}
}
