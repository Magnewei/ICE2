package com.example.ice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BattleSimController {
    @FXML
    private ImageView  EnemySprite, PlayerSprite, StageTemp, ShrekBorder;
    @FXML
    private Button SelectMove1, SelectMove2, SelectMove3, SelectMove4, ChooseMon1,ChooseMon2,ChooseMon3;
    @FXML
    private Label ActiveMon1, ActiveMon2, ChooseMon1Name, ChooseMon2Name, ChooseMon3Name, MoveName1, MoveName2, MoveName3, MoveName4, damageBox;
    @FXML
    private ProgressBar enemyProgressBar, playerProgressBar;
    private User currentPlayer, enemyPlayer;
    private final BattleSim sim = new BattleSim();

    private MediaPlayer musicPlayer;



    public void setup(User currentPlayer, User enemyPlayer) {
        File music = new File("MediaFiles/BattleSimTrack.mp3");
        Media musicMedia = new Media(music.toURI().toString());
        musicPlayer = new MediaPlayer(musicMedia);
        musicPlayer.setVolume(0.1);
        musicPlayer.play();
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

        PlayerSprite.setImage(currentPlayer.getCurrentDatamon().getSprite());
        EnemySprite.setImage(enemyPlayer.getCurrentDatamon().getSprite());

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

        // Changes images of enemy and player sprites.
        PlayerSprite.setImage(currentPlayer.getCurrentDatamon().getSprite());
        EnemySprite.setImage(enemyPlayer.getCurrentDatamon().getSprite());
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
        updateDamageBox();
    }

    @FXML
    public void move2Button(ActionEvent e){
        sim.Fight(2);
        showMonButtons();
        updateDamageBox();
    }

    @FXML
    public void move3Button(ActionEvent e){
        sim.Fight(3);
        showMonButtons();
        updateDamageBox();
    }

    @FXML
    public void move4Button(ActionEvent e){
        sim.Fight(4);
        showMonButtons();
        updateDamageBox();
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

    private void updateDamageBox() {
        String chatBox = sim.getMovePrint();
        damageBox.setText(chatBox);
    }
}

