package com.example.ice;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MenuController implements Initializable {
    @FXML
    private MediaView MenuBackground;
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Stage userChoices = new Stage();
    private DBConnector io = new DBConnector();
    private User currentUser = new User();
    private User NPC = new User("Hal9000", "");
    private MediaPlayer mediaPlayer, musicPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        File file = new File("MediaFiles/DataMonA.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MenuBackground.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(55);

        File music = new File("MediaFiles/MenuTrack.mp3");
        Media musicMedia = new Media(music.toURI().toString());
        musicPlayer = new MediaPlayer(musicMedia);
        musicPlayer.setVolume(0.1);
        musicPlayer.play();
        musicPlayer.setCycleCount(55);
    }

    // Parses database login information. Returns user if username and password match found.
    @FXML
    private void loginPressed(ActionEvent event) {
        try {
            currentUser = io.login(usernameField.getText(), passwordField.getText());
            if (currentUser != null) {
                Platform.runLater(() -> {
                    try {

                        // Pause music on scene end.
                        musicPlayer.pause();

                        // Hide current window on new end.
                        ((Node)(event.getSource())).getScene().getWindow().hide();

                        // Load new window & scene.
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selector.fxml"));
                        Parent root = loader.load();

                        // Pass correct MenuController object to SelectorController.
                        SelectorController selectorController = loader.getController();
                        selectorController.setup(currentUser, NPC);

                        // Load new scene
                        userChoices.setScene(new Scene(root));;
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error1", "An error occurred while loading the next screen.");
                        e.printStackTrace();
                    }
                });

            } else {
                showErrorDialog("Error!", "Username or password is wrong.");
            }
        } catch (FileNotFoundException e) {
            showErrorDialog("Error3", "An unexpected error occured: " + e.getMessage());

        } catch (Exception e) {
            showErrorDialog("Error4", "An unexpected error occured: " + e.getMessage());
        }
    }

    // Register user and inserts username and password into database.
    @FXML
    private void registerPressed(ActionEvent event) throws SQLException {
        if (io.createUser(usernameField.getText(), passwordField.getText()).equals(true)) {
           showErrorDialog("Success!", "You can now proceed to login!");

        } else {
            showErrorDialog("Failure!", "User already exists.");
        }
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void ExitButton() {
        Platform.exit();
    }


}

