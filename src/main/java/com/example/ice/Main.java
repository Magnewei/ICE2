package com.example.ice;

import com.example.ice.Datamons.Fred1;
import com.example.ice.Datamons.Fred2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        Fred1 f = new Fred1();
        Fred2 f2 = new Fred2();
        f.move1(f2);
        //launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Selector.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Datamon.exe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}