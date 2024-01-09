package core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddProject extends Application {

    

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ExecuSync Projects - Ajouter projets");

        
        Path cheminIcone = Paths.get("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\icone.png");
		File iconeFile = cheminIcone.toFile();
		if (iconeFile.exists()) {
		    String iconePath = iconeFile.toURI().toString();
		    Image icon = new Image(iconePath);
		    primaryStage.getIcons().add(icon);
		} else {
		    System.err.println("Resource not found: " + iconeFile.getAbsolutePath());
		}
		
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Project ID
        Label idLabel = new Label("ID:");
        TextField idTextField = new TextField();
        idTextField.setPromptText("Entrer un projectID");
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idTextField, 1, 0);

        // nom projet
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Entrer project Name");
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);

        // Start Date
        Label startDateLabel = new Label("Start Date:");
        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setValue(LocalDate.now());
        gridPane.add(startDateLabel, 0, 2);
        gridPane.add(startDatePicker, 1, 2);

        // End Date
        Label endDateLabel = new Label("End Date:");
        DatePicker endDatePicker = new DatePicker();
        gridPane.add(endDateLabel, 0, 3);
        gridPane.add(endDatePicker, 1, 3);

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> handleSubmit(
                idTextField.getText(),
                nameTextField.getText(),
                startDatePicker.getValue(),
                endDatePicker.getValue()
        ));primaryStage.close();
        gridPane.add(submitButton, 1, 4);

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void handleSubmit(String id, String name, LocalDate startDate, LocalDate endDate) {
        try {
            long idLong = Long.parseLong(id);
            Date startDateDate = java.sql.Date.valueOf(startDate);
            Date endDateDate = endDate != null ? java.sql.Date.valueOf(endDate) : null;

            
            String jdbcUrl = "jdbc:mysql://localhost:3306/execusync";
            String username = "root";
            String password = "root";

            // Establish the database connection
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                // Prepare the SQL statement for insertion
                String sql = "INSERT INTO projects (id, name, start_date, end_date) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setLong(1, idLong);
                    preparedStatement.setString(2, name);
                    preparedStatement.setDate(3, new java.sql.Date(startDateDate.getTime()));
                    preparedStatement.setDate(4, endDateDate != null ? new java.sql.Date(endDateDate.getTime()) : null);

                    // Execute the SQL statement
                    preparedStatement.executeUpdate();

                    System.out.print("Success");
                }
            } catch (SQLException e) {
                showAlert("Error", "Échec de l'insertion des détails du projet dans la base de données : " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            showAlert("Invalid ID", "Veuillez saisir un identifiant valide.");
        }
    }

    

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}

