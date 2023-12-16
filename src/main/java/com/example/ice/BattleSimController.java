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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class BattleSimController implements Initializable {
    @FXML
    private ImageView StageTemp;
    @FXML
    private Label ActiveMon1, ActiveMon2;
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
    @FXML
    private ProgressBar enemyProgressBar, playerProgressBar;
    private User currentPlayer;
    private User enemyPlayer;
    private final BattleSim sim = new BattleSim();
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setup(User currentPlayer, User enemyPlayer) {

        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
        sim.setup(currentPlayer, enemyPlayer);
        updateMonLabels();
        currentPlayer.setCurrentDatamon(0);
        enemyPlayer.setCurrentDatamon(0);
        updateMoveLabels();
        updateProgress();
        updateActiveMonLabels();
        playerProgressBar.setProgress(currentPlayer.getCurrentDatamon().getPercentageHealth());
        if(enemyPlayer.getDatamons().size()>0){
            enemyProgressBar.setProgress(enemyPlayer.getDatamons().get(0).getPercentageHealth());
        }

    }

    // Updates the player's Datamon choice buttons depending on available Datamons.
    private void showMonButtons() {
        List<Button> buttons = new ArrayList<>();
        int amountOfDatamons = currentPlayer.getDatamons().size();
        updateMoveLabels();
        ChooseMon1.setVisible(false);
        ChooseMon2.setVisible(false);
        ChooseMon3.setVisible(false);

        buttons.add(ChooseMon1);
        buttons.add(ChooseMon2);
        buttons.add(ChooseMon3);
        updateMonLabels();
        updateActiveMonLabels();
        updateProgress();

        for(int i = 0; i <  amountOfDatamons ; i++){
            buttons.get(i).setVisible(true);
        }
    }

    private void updateProgress() {
        if(enemyPlayer.getDatamons().size()>0){
            enemyProgressBar.setProgress(enemyPlayer.getDatamons().get(0).getPercentageHealth());
        }
        playerProgressBar.setProgress(currentPlayer.getCurrentDatamon().getPercentageHealth());
    }

    @FXML
    public void chooseMon1(ActionEvent e){
        currentPlayer.setCurrentDatamon(0);
        updateMoveLabels();
        showMonButtons();
    }

    @FXML
    public void chooseMon2(ActionEvent e){
        currentPlayer.setCurrentDatamon(1);
        updateMoveLabels();
        showMonButtons();
    }

    @FXML
    public void chooseMon3(ActionEvent e){
        currentPlayer.setCurrentDatamon(2);
        updateMoveLabels();
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

    private void updateMoveLabels(){
        MoveName1.setText(currentPlayer.getCurrentDatamon().getMove1Name());
        MoveName2.setText(currentPlayer.getCurrentDatamon().getMove2Name());
        MoveName3.setText(currentPlayer.getCurrentDatamon().getMove3Name());
        MoveName4.setText(currentPlayer.getCurrentDatamon().getMove4Name());
    }

    private void updateMonLabels(){
        if(currentPlayer.getDatamons().size()>2){
            ChooseMon3Name.setText(currentPlayer.getDatamons().get(2).getName());
        }
        if(currentPlayer.getDatamons().size()>1) {
            ChooseMon2Name.setText(currentPlayer.getDatamons().get(1).getName());
        }
        ChooseMon1Name.setText(currentPlayer.getDatamons().get(0).getName());


    }

    private void updateActiveMonLabels(){
        ActiveMon1.setText(currentPlayer.getCurrentDatamon().getName());
        ActiveMon2.setText(enemyPlayer.getDatamons().get(0).getName());
    }

}

