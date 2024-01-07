package core;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginView extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		
		VBox vbox = new VBox();
	
		Image image = new Image("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\Logo JAVA.png");
		ImageView imageview = new ImageView(image);
		
		Path cheminIcone = Paths.get("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\icone.png");
		File iconeFile = cheminIcone.toFile();
		if (iconeFile.exists()) {
		    String iconePath = iconeFile.toURI().toString();
		    Image icon = new Image(iconePath);
		    stage.getIcons().add(icon);
		} else {
		    System.err.println("Resource not found: " + iconeFile.getAbsolutePath());
		}
		TextField tf1 = new TextField();
		tf1.setPromptText("Identifiant");
		PasswordField tf2 = new PasswordField();
		tf2.setPromptText("Mot de passe");
		RadioButton rdBtn1 = new RadioButton("Responsable");
		RadioButton rdBtn2 = new RadioButton("Intervenant");
		
		
		ToggleGroup group = new ToggleGroup();
		rdBtn1.setToggleGroup(group);
		rdBtn2.setToggleGroup(group);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(rdBtn1,rdBtn2);
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		
		Button btn = new Button("Se Connecter");
		btn.setOnMouseClicked((evt)->{
			String user=tf1.getText();
			String passwd=tf2.getText();
			System.out.println("Votre identifiant est : "+user);
			System.out.println("Votre mot de passe est : "+passwd);
			vbox.getChildren().removeAll(tf1,tf2,hbox,btn);
			Text loggin = new Text("You are successfully logged");
			vbox.getChildren().add(loggin);
		});
		
		vbox.getChildren().addAll(imageview,tf1,tf2,hbox,btn);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setFillWidth(false);

		BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox.setBackground(background);
		
		Scene scene = new Scene(vbox);
		
		stage.setScene(scene);
		stage.setTitle("ExecuSync Projects - Login");
		stage.setHeight(500);
		stage.setWidth(400);
		stage.show();
	}
	public static void main(String[] args) {
        launch();
    }
}
