package com.example.ice;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BattleSimController {
    @FXML
    private ImageView EnemySprite, PlayerSprite, StageTemp, ShrekBorder;
    @FXML
    private Button SelectMove1, SelectMove2, SelectMove3, SelectMove4, ChooseMon1, ChooseMon2, ChooseMon3;
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
        if (!enemyPlayer.getDatamons().isEmpty()) {
            enemyProgressBar.setProgress(enemyPlayer.getDatamons().getFirst().getPercentageHealth());
        }

        PlayerSprite.setImage(currentPlayer.getCurrentDatamon().getSprite());
        EnemySprite.setImage(enemyPlayer.getCurrentDatamon().getSprite());
    }

    /**
     * This method updates the player's Datamon's choice buttons depending on available Datamons. This means that if we have 2 Datamons in our "deck" then 2 buttons is being displayed.
     */
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

        for (int i = 0; i < amountOfDatamons; i++) {
            buttons.get(i).setVisible(true);
        }
    }

    /**
     * Nasseren cooked this method. If currentPlayer Datamon is tobias, and tobias has casted his 4th ability 4 times, then he transforms into shrek.
     */
    private void ShrekEasterEgg() {
        if (currentPlayer.getCurrentDatamon().getName().equals("Tobias") && currentPlayer.setCurrentDatamon().getCreatureType().equals("TobiasShrek")) {
            String path = "file:" + "src/main/resources/com/example/ice/TobiasSprite.png";

            // Import image file.
            Image image = new Image(path);

            // Instantiate ImageView and set image.
            PlayerSprite.setImage(image);
            showMonButtons();
        }
    }


    /**
     * This method Updates our progressbar, depending on how much hp the attacker/Defenders datamon has left. We are also changing the Sprite depending on which Datamon we are using
     */
    private void updateProgress() {
        if (!enemyPlayer.getDatamons().isEmpty()) {
            enemyProgressBar.setProgress(enemyPlayer.getDatamons().getFirst().getPercentageHealth());
        }
        playerProgressBar.setProgress(currentPlayer.getCurrentDatamon().getPercentageHealth());

        PlayerSprite.setImage(currentPlayer.getCurrentDatamon().getSprite());
        EnemySprite.setImage(enemyPlayer.getCurrentDatamon().getSprite());
    }

    /**
     * These 3 Methods is used so the user can swap between its Datamons
     *
     * @param e
     */
    @FXML
    public void chooseMon1(ActionEvent e) {
        currentPlayer.setCurrentDatamon(0);
        updateMoveLabels();
        showMonButtons();
    }

    @FXML
    public void chooseMon2(ActionEvent e) {
        currentPlayer.setCurrentDatamon(1);
        updateMoveLabels();
        showMonButtons();

    }

    @FXML
    public void chooseMon3(ActionEvent e) {
        currentPlayer.setCurrentDatamon(2);
        updateMoveLabels();
        showMonButtons();
    }

    /**
     * These 4 methods are used to connect the 4 Datamons attacks, to its buttons.
     *
     * @param e
     */
    @FXML
    public void move1Button(ActionEvent e) {
        sim.Fight(1);
        showMonButtons();
        updateDamageBox();
        onWin(e);
    }

    @FXML
    public void move2Button(ActionEvent e) {
        sim.Fight(2);
        showMonButtons();
        updateDamageBox();
        onWin(e);

    }

    @FXML
    public void move3Button(ActionEvent e) {
        sim.Fight(3);
        showMonButtons();
        updateDamageBox();
        onWin(e);

    }

    @FXML
    public void move4Button(ActionEvent e) {
        sim.Fight(4);
        showMonButtons();
        updateDamageBox();
        onWin(e);

        ShrekEasterEgg();
    }

    /**
     * Updating the moveLabels text depending on what Datamon is being used
     */
    private void updateMoveLabels() {
        MoveName1.setText(currentPlayer.getCurrentDatamon().getMove1Name());
        MoveName2.setText(currentPlayer.getCurrentDatamon().getMove2Name());
        MoveName3.setText(currentPlayer.getCurrentDatamon().getMove3Name());
        MoveName4.setText(currentPlayer.getCurrentDatamon().getMove4Name());
    }

    /**
     * Updating the Name Labels depending on what Datamon the player still has left.
     */
    private void updateMonLabels() {
        if (currentPlayer.getDatamons().size() > 2) {
            ChooseMon3Name.setText(currentPlayer.getDatamons().get(2).getName());
        }
        if (currentPlayer.getDatamons().size() > 1) {
            ChooseMon2Name.setText(currentPlayer.getDatamons().get(1).getName());
        }
        if (currentPlayer.getDatamons().size() > 0) {
            ChooseMon1Name.setText(currentPlayer.getDatamons().get(0).getName());
        }
    }

    /**
     * Updating the Name Label depending on what Datamon is currently Active.
     */
    private void updateActiveMonLabels() {
        ActiveMon1.setText(currentPlayer.getCurrentDatamon().getName());
        if(!enemyPlayer.getDatamons().isEmpty()){
            ActiveMon2.setText(enemyPlayer.getDatamons().get(0).getName());
        }

    }


     //Updating DamageBox.

    private void updateDamageBox() {
        String chatBox = sim.getMovePrint();
        damageBox.setText(chatBox);
    }

    // Loads EndScreen.fxml if game is finished.
    private void onWin(Event event) {
        if (sim.checkIfWin()) {
            Stage userChoices = new Stage();
            try {
                // Pause music on scene end.
                musicPlayer.pause();
                // Hide current window on new end.
                ((Node) (event.getSource())).getScene().getWindow().hide();

                // Load new window & scene.
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EndScreen.fxml"));
                Parent root = loader.load();

                // Pass correct BattleSim object to EndScreenController.
                EndScreenController endController = loader.getController();
                endController.setup(sim);

                // Load new scene
                userChoices.setScene(new Scene(root));
                userChoices.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            // Moved from BattleSimController to EndScreen.fxml if checkIfWin returned true. Else continue.
        }
    }
}


