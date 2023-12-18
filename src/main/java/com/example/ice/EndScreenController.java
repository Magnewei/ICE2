package com.example.ice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class EndScreenController implements Initializable {
    private File file;
    private BattleSim Sim = new BattleSim();
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView MediaEnd;
    private User currentPlayer, EnemyPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        file = FilePath();
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaEnd.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    // TODO:
    // Test if FilePath() loads scene correctly


    // Returns an end screen, depending on the winner of the game.
    public File FilePath() {
        File File;
        if (Sim.getFightResult().equals("Hal9000")) {
            File = new File("MediaFiles/MediaEndWin.mp4");  // NPC wins
            return File;
        }
            File = new File("MediaFiles/MediaEndDie.mp4");  // Player wins
            return File;
    }
}
