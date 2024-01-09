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

public class AddMateriel extends Application {
	
	private Materiel newMat;
	
	public Materiel getNewMateriel () {
		return this.newMat;
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
		
		Text ajouterText = new Text("Ajouter un materiel");
		
		Label id = new Label("ID");
		TextField idField = new TextField();
		idField.setPrefWidth(200);
		
		Label title = new Label("Title");
		TextField titleField = new TextField();
		
		Label designation = new Label("Designation");
		TextField desigField = new TextField();
		
		
		
		GridPane grpane = new GridPane();
		grpane.addRow(0, id, idField);
		grpane.addRow(1, title, titleField);
		grpane.addRow(2, designation, desigField);

		grpane.setAlignment(Pos.CENTER);
		grpane.setVgap(20);
		grpane.setHgap(20);
		
		Button ajouterBtn = new Button("Ajouter");
		ajouterBtn.setOnMouseClicked((evt)->{
			Long ID = Long.parseLong(idField.getText());
			String TITLE = titleField.getText();
			String DESIG = desigField.getText(); 
			
			this.newMat = new Materiel(ID, TITLE, DESIG, new Responsable());
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
		stage.setTitle("ExecuSync Projects - Add Materials");
		stage.setHeight(700);
		stage.setWidth(400);
		stage.showAndWait();
		
	}
}
