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

public class BattleSim {

    private User currentPlayer;
    private User enemyPlayer;
    private User player;
    private User NPC;
    private Random random = new Random();


    public void setup(User player, User NPC) {
        this.player = player;
        this.NPC = NPC;
        currentPlayer = player;
        enemyPlayer = NPC;


    }



    // Remove the current Datamon if its HP is zero or negative
    private void checkIfDead() {
        if (enemyPlayer.getCurrentDatamon().getHP() <= 0) {
            enemyPlayer.removeDatamon(enemyPlayer.getCurrentDatamon());

            if (!enemyPlayer.getDatamons().isEmpty()) {
                Datamon randomDatamon = enemyPlayer.getDatamons().get(random.nextInt(enemyPlayer.getDatamons().size()));
                enemyPlayer.setCurrentDatamon(randomDatamon);
            }
        }
    }


    public Boolean checkIfWin() {
        if (player.getDatamons().isEmpty()) {
            showErrorDialog("Winner found ", NPC.getUsername() + " won!");
            return true;
        } else if (NPC.getDatamons().isEmpty()) {
            showErrorDialog("Winner found ", player.getUsername() + " won!");
            return true;
        } else {
            return false;
        }


    }


    public void Fight(int pick) {
        if (enemyPlayer != null && currentPlayer != null) {
        checkIfDead();
        checkIfWin();

        int methodNumber;
            System.out.println("Current Player: " + currentPlayer.getUsername());
            System.out.println("Enemy Player: " + enemyPlayer.getUsername());
            if (!checkIfWin()) {
                checkIfDead();
                switchUser();

                if (currentPlayer.equals(NPC)) {
                    methodNumber = random.nextInt(1, 4);
                } else {
                    methodNumber = pick;
                }
                switch (methodNumber) {
                    case 1:
                        move1(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                        checkIfDead();
                        checkIfWin();
                        break;

                    case 2:
                        move2(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                        checkIfDead();
                        checkIfWin();
                        break;

                    case 3:
                        move3(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                        checkIfDead();
                        checkIfWin();
                        break;

                    case 4:
                        move4(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                        checkIfDead();
                        checkIfWin();
                        break;

                    default:
                        System.out.println("Something went wrong.");

                }
            }
        }
    }


    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void chooseMon() {
        //TODO: Add måde at vælge på.
        //Generer buttons ud fra list.size() med navne på objekter.
    }

    private void switchUser() {
        if (currentPlayer.equals(player)) {
            currentPlayer = enemyPlayer;
            enemyPlayer = player;
        } else {
            currentPlayer = player;
            enemyPlayer = NPC;
        }
    }


    // Checks if there's a winner.
    public void move1(Datamon attacker, Datamon defender) {
        defender.setHP(defender.getHP() - attacker.move1(defender));

    }
    public void move2(Datamon attacker, Datamon defender) {
        defender.setHP(defender.getHP() - attacker.move2(defender));

    }

    public void move3(Datamon attacker, Datamon defender) {
        defender.setHP(defender.getHP() - attacker.move3(defender));
    }
    public void move4(Datamon attacker, Datamon defender) {
        defender.setHP(defender.getHP() - attacker.move4(defender));
    }


}
