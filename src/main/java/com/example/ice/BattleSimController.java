package com.example.ice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BattleSimController {
    /*
    private User player;    // selectorController.getCurrentUser();
    private User NPC; // selectorController.getNPC();

     */
    private User currentPlayer;
    private User enemyPlayer;
    BattleSim sim = new BattleSim();

    public void setup(User currentPlayer, User enemyPlayer) {
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
        sim.setup(currentPlayer, enemyPlayer);

    }


    @FXML
    public void move1Button(ActionEvent e){
        sim.ChooseMove(1);
        sim.Fight();
    }

    @FXML
    public void move2Button(ActionEvent e){
        sim.ChooseMove(2);
        sim.Fight();
    }

    @FXML
    public void move3Button(ActionEvent e){
        sim.ChooseMove(3);
        sim.Fight();
    }

    @FXML
    public void move4Button(ActionEvent e){
        sim.ChooseMove(4);
        sim.Fight();
    }



}