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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class profilView extends Application {
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
		
		Button accueil = new Button("< Accueil");
		Button modifier = new Button("Modifier");
		
		HBox hbox1 = new HBox();
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(80);
		hbox1.getChildren().addAll(accueil, modifier);
		
		Label nom = new Label("Nom");
		TextField nomField = new TextField();
		
		Label prenom = new Label("Prénom");
		TextField prenomField = new TextField();
		
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
		
		Button enregister = new Button("Enregistrer");
		
		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(50);
		vbox1.getChildren().addAll(hbox1,grpane,enregister);
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox1.setBackground(background);
		
		Scene scene = new Scene(vbox1);
		
		stage.setScene(scene);
		stage.setTitle("ExecuSync Projects - Profil");
		stage.setHeight(700);
		stage.setWidth(400);
		stage.show();
		
	}
}
