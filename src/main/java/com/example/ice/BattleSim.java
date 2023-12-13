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


    public void setup(User currentPlayer, User enemyPlayer) {
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;


    }

    public void ChooseMove(int pick) {
        int methodNumber;

        if (currentPlayer != null) {

            if (currentPlayer.equals(enemyPlayer)) {
                Random random = new Random();
                methodNumber = random.nextInt(4) + 1;
            } else {
                methodNumber = pick;
            }


            switch (methodNumber) {
                case 1:
                    move1(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                    break;

                case 2:
                    move2(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                    break;

                case 3:
                    move3(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                    break;

                case 4:
                    move4(currentPlayer.getCurrentDatamon(), enemyPlayer.getCurrentDatamon());
                    break;

                default:
                    System.out.println("Something went wrong.");
            }

        } else {
            System.out.println("Current player is null.");
        }


    }

    private void checkIfDead() {
        if (!enemyPlayer.getDatamons().isEmpty() && enemyPlayer.getCurrentDatamon().getHP() <= 0) {
            enemyPlayer.removeDatamon(enemyPlayer.getCurrentDatamon());
            enemyPlayer.getDatamons().get(0);
        }
    }

    private Boolean checkIfWin() {
        if (enemyPlayer.getDatamons().size() <= 0) {
            System.out.println("Winner found test");
            return true;
        }
        return false;
    }

    public void Fight() {

        if (enemyPlayer != null && currentPlayer != null) {
            if (checkIfWin()) {
                showErrorDialog("Winner found", currentPlayer.getUsername() + "won!");
            }

            // checkIfDead();
            // switchUser();
        } else {
            System.out.println("Fight() users are null.");
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
        if (currentPlayer.equals(currentPlayer)) {
            currentPlayer = enemyPlayer;
            enemyPlayer = currentPlayer;
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
