package com.example.ice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class BattleSimController implements Initializable {


    @FXML
    private Label ActiveMon1, ActiveMon2;

    @FXML
    private ProgressBar Hpbar2;

    @FXML
    private ProgressBar Hpbar1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SelectMove1, SelectMove2, SelectMove3, SelectMove4;


    @FXML
    private Button ChooseMon1,ChooseMon2,ChooseMon3;


    @FXML
    private ImageView VisualMon1, VisualMon2;


    @FXML
    private Label MoveName1, MoveName2, MoveName3, MoveName4;

    @FXML
    private Label ChooseMon1Name, ChooseMon2Name, ChooseMon3Name;

    private User currentPlayer;
    private User enemyPlayer;
    private final BattleSim sim = new BattleSim();

    @FXML
    private ProgressBar enemyProgressBar, playerProgressBar;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setup(User currentPlayer, User enemyPlayer) {
        File file = new File("MediaFiles/DataMonB.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        SimBackground.setMediaPlayer(mediaPlayer);
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
        sim.setup(currentPlayer, enemyPlayer);
        updateMonLabels();
        currentPlayer.setCurrentDatamon(0);
        enemyPlayer.setCurrentDatamon(0);

    }

    //

    public void showMonButtons() {
        List<Button> buttons = new ArrayList<>();
        int amountOfDatamons = currentPlayer.getDatamons().size();
        updateMoveLabels();
        ChooseMon1.setVisible(false);
        ChooseMon2.setVisible(false);
        ChooseMon3.setVisible(false);
        buttons.add(ChooseMon1);
        buttons.add(ChooseMon2);
        buttons.add(ChooseMon3);

        updateProgress();

        for(int i = 0; i <  amountOfDatamons ; i++){
            buttons.get(i).setVisible(true);
        }
    }

    public void updateProgress() {
        enemyProgressBar = new ProgressBar(enemyPlayer.getCurrentDatamon().getPercentageHealth());
        playerProgressBar = new ProgressBar(currentPlayer.getCurrentDatamon().getPercentageHealth());

    }


    @FXML
    public void chooseMon1(ActionEvent e){
        currentPlayer.setCurrentDatamon(0);
        System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void chooseMon2(ActionEvent e){
        currentPlayer.setCurrentDatamon(1);
        System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void chooseMon3(ActionEvent e){
        currentPlayer.setCurrentDatamon(2);
       System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void move1Button(ActionEvent e){
        sim.Fight(1);
        showMonButtons();
    }

    @FXML
    public void move2Button(ActionEvent e){
        sim.Fight(2);
        showMonButtons();
    }

    @FXML
    public void move3Button(ActionEvent e){
        sim.Fight(3);
        showMonButtons();
    }

    @FXML
    public void move4Button(ActionEvent e){
        sim.Fight(4);
        showMonButtons();
    }
}

