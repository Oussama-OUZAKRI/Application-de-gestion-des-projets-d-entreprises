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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class profilView extends Application {
	
	private String[] session = Session.getutilisateurConnecte();
	
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
		accueil.setOnMouseClicked((evt)->{
			stage.close();
		});
		Button modifier = new Button("Modifier");
		
		HBox hbox1 = new HBox();
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(80);
		hbox1.getChildren().addAll(accueil, modifier);
		
		Label prenom = new Label("Prénom");
		TextField prenomField = new TextField();
		prenomField.setText(session[0]);
		prenomField.setEditable(false);
		prenomField.setMouseTransparent(true);
		prenomField.setPrefWidth(200);
		
		Label nom = new Label("Nom");
		TextField nomField = new TextField();
		nomField.setText(session[1]);
		nomField.setEditable(false);
		nomField.setMouseTransparent(true);
		
		Label adressePostale = new Label("Adresse Postale");
		TextField adressePostaleField = new TextField();
		adressePostaleField.setText(session[2]);
		adressePostaleField.setEditable(false);
		adressePostaleField.setMouseTransparent(true);
		
		Label numTel = new Label("Numéro de Téléphone");
		TextField numTelField = new TextField();
		numTelField.setText(session[3]);
		numTelField.setEditable(false);
		numTelField.setMouseTransparent(true);
		
		Label adresseEmail = new Label("Adresse Email");
		TextField adresseEmailField = new TextField();
		adresseEmailField.setText(session[4]);
		adresseEmailField.setEditable(false);
		adresseEmailField.setMouseTransparent(true);
		
		Label numCarteIdentite = new Label("N° Carte d'identité");
		TextField numCarteIdentiteField = new TextField();
		numCarteIdentiteField.setText(session[5]);
		numCarteIdentiteField.setEditable(false);
		numCarteIdentiteField.setMouseTransparent(true);
		
		Label numCompteBancaire = new Label("N° Compte Bancaire");
		TextField numCompteBancaireField = new TextField();
		numCompteBancaireField.setText(session[6]);
		numCompteBancaireField.setEditable(false);
		numCompteBancaireField.setMouseTransparent(true);
		
		Label identifiant = new Label("Identifiant");
		TextField identifiantField = new TextField();
		identifiantField.setText(session[7]);
		identifiantField.setEditable(false);
		identifiantField.setMouseTransparent(true);
		
		
		Label motDePasse = new Label("Mot De Passe");
		TextField motDePasseField = new TextField();
		motDePasseField.setText(session[8]);
		motDePasseField.setEditable(false);
		motDePasseField.setMouseTransparent(true);
		
		modifier.setOnMouseClicked((evt) -> {
		    prenomField.setEditable(true);
		    nomField.setEditable(true);
		    adressePostaleField.setEditable(true);
		    numTelField.setEditable(true);
		    adresseEmailField.setEditable(true);
		    numCarteIdentiteField.setEditable(true);
		    numCompteBancaireField.setEditable(true);
		    identifiantField.setEditable(true);
		    motDePasseField.setEditable(true);

		    prenomField.setMouseTransparent(false);
		    nomField.setMouseTransparent(false);
		    adressePostaleField.setMouseTransparent(false);
		    numTelField.setMouseTransparent(false);
			adresseEmailField.setMouseTransparent(false);
			numCarteIdentiteField.setMouseTransparent(false);
			numCompteBancaireField.setMouseTransparent(false);
			identifiantField.setMouseTransparent(false);
			motDePasseField.setMouseTransparent(false);
		});
		
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
		
		Button enregistrer = new Button("Enregistrer");
		enregistrer.setOnMouseClicked((evt)->{
			prenomField.setEditable(false);
			nomField.setEditable(false);
			adressePostaleField.setEditable(false);
			numTelField.setEditable(false);
			adresseEmailField.setEditable(false);
			numCarteIdentiteField.setEditable(false);
			numCompteBancaireField.setEditable(false);
			identifiantField.setEditable(false);
			motDePasseField.setEditable(false);
			
			prenomField.setMouseTransparent(true);
		    nomField.setMouseTransparent(true);
		    adressePostaleField.setMouseTransparent(true);
		    numTelField.setMouseTransparent(true);
			adresseEmailField.setMouseTransparent(true);
			numCarteIdentiteField.setMouseTransparent(true);
			numCompteBancaireField.setMouseTransparent(true);
			identifiantField.setMouseTransparent(true);
			motDePasseField.setMouseTransparent(true);
			
			mettreAJourUtilisateur(prenomField.getText(), nomField.getText(), adressePostaleField.getText(), 
					numTelField.getText(), adresseEmailField.getText(), numCarteIdentiteField.getText(), 
					numCompteBancaireField.getText(), identifiantField.getText(), motDePasseField.getText());
			
		});
		
		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(50);
		vbox1.getChildren().addAll(hbox1,grpane,enregistrer);
		
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
	
	private void mettreAJourUtilisateur(String prenomField, String nomField, String addressePostaleField,
			String numTelField,String adresseEmailField,String numCarteIdentiteField,
			String numCompteBancaireField, String identifiantField, String motDePasseField) {

	    UserDAO.mettreAJourUtilisateur(prenomField, nomField, addressePostaleField,
	    		numTelField, adresseEmailField, numCarteIdentiteField, numCompteBancaireField,
	    		identifiantField, motDePasseField);
	    
	    session[0] = prenomField;
	    session[1] = nomField;
	    session[2] = addressePostaleField;
	    session[3] = numTelField;
	    session[4] = adresseEmailField;
	    session[5] = numCarteIdentiteField;
	    session[6] = numCompteBancaireField;
	    session[7] = identifiantField;
	    session[8] = motDePasseField;
	}
}
