package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Date;

public class showProjects extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ExecuSync Projects: Affichage des projets");

        Path cheminIcone = Paths.get("C:\\Users\\Oussama Ouzakri\\Desktop\\Projet Java\\icone.png");
        File iconeFile = cheminIcone.toFile();
        if (iconeFile.exists()) {
            String iconePath = iconeFile.toURI().toString();
            Image icon = new Image(iconePath);
            primaryStage.getIcons().add(icon);
        } else {
            System.err.println("Resource not found: " + iconeFile.getAbsolutePath());
        }

        // Create a TableView
        TableView<Projet> tableView = new TableView<>();

        // Define columns
        TableColumn<Projet, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Projet, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Projet, Date> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<Projet, Date> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        TableColumn<Projet, Responsable> responsibleColumn = new TableColumn<>("Responsable");
        responsibleColumn.setCellValueFactory(new PropertyValueFactory<>("responsible"));

        tableView.getColumns().addAll(idColumn, nameColumn, startDateColumn, endDateColumn, responsibleColumn);

        fetchSQL(tableView);

        Scene scene = new Scene(tableView, 600, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void fetchSQL(TableView<Projet> tableView) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/execusync";
        String username = "root";
        String password = "123456789";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT * FROM projects";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    Responsable responsable = new Responsable();  

                    Projet project = new Projet(id, name, startDate, endDate, responsable);
                    tableView.getItems().add(project);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
