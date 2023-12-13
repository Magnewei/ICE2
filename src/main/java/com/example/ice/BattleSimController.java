package com.example.ice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BattleSimController implements Initializable {
    private User currentPlayer;
    private User enemyPlayer;
    private final BattleSim sim = new BattleSim();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setup(User currentPlayer, User enemyPlayer) {
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
        sim.setup(currentPlayer, enemyPlayer);
    }

    @FXML
    public void move1Button(ActionEvent e){
        sim.Fight(1);
    }

    @FXML
    public void move2Button(ActionEvent e){
        sim.Fight(2);
    }

    @FXML
    public void move3Button(ActionEvent e){
        sim.Fight(3);
    }

    @FXML
    public void move4Button(ActionEvent e){
        sim.Fight(4);
    }

}