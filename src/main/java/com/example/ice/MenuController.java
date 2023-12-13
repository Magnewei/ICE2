package com.example.ice;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class MenuController implements Initializable {
    @FXML
    private MediaView MenuBackground;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Stage userChoices = new Stage();
    private DBConnector io = new DBConnector();
    private User currentUser = new User();
    private User NPC = new User("Hal9000", "");
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        File file = new File("MediaFiles/DataMonA.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MenuBackground.setMediaPlayer(mediaPlayer);
    }

    @FXML
    private void loginPressed(ActionEvent event) {
        try {
            currentUser = io.login(usernameField.getText(), passwordField.getText());

            if (currentUser != null) {


                Platform.runLater(() -> {
                    try {

                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selector.fxml"));
                        Parent root = loader.load();

                        SelectorController selectorController = loader.getController();
                        selectorController.setup(currentUser, NPC);

                        userChoices.setScene(new Scene(root));;
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error1", "An error occurred while loading the next screen.");
                        e.printStackTrace();
                    }
                });

            } else {
                showErrorDialog("Error2", "An error occurred while loading the next screen.");
            }
        } catch (FileNotFoundException e) {
            showErrorDialog("Error3", "An unexpected error occured: " + e.getMessage());

        } catch (Exception e) {
            showErrorDialog("Error4", "An unexpected error occured: " + e.getMessage());
        }
    }
    @FXML
    private void registerPressed(ActionEvent event) {
        try {
            io.createUser(usernameField.getText(), passwordField.getText());

            if (currentUser != null) {

                Platform.runLater(() -> {

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selector.fxml"));
                        Parent root = loader.load();
                        userChoices.setScene(new Scene(root));
                        userChoices.show();

                    } catch (IOException e) {
                        showErrorDialog("Error1", "An error occurred while loading the next screen.");
                    }
                });

            } else {
                showErrorDialog("Register Success!", "You can now proceed to login!");
            }
        } catch (Exception e) {
            showErrorDialog("Error3", "An unexpected error occured: " + e.getMessage());
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
    private void PlayMenu(MouseEvent mouseEvent) {
        mediaPlayer.play();
        mediaPlayer.setRate(1.1);
        mediaPlayer.setVolume(0.5);

    }
}

