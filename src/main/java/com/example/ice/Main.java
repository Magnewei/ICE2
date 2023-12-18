package com.example.ice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Datamon.exe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}