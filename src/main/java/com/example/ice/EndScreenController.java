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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        FilePath();
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaEnd.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

    }
    public void FilePath() {
        File File;
        if (Sim.getFightResult().equals("Hal900")) {
            File = new File("MediaFiles/MediaEndWin.mp4");
        } else {
            File = new File("MediaFiles/MediaEndDie.mp4");
        }
    }
}
