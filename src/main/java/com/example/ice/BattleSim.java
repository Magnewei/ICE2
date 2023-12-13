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
    private final Random random = new Random();

    public void setup(User player, User NPC) {
        this.player = player;
        this.NPC = NPC;
        currentPlayer = player;
        enemyPlayer = NPC;
    }


    // Checks if Datamon is dead.
    private void checkIfDead() {
        if (enemyPlayer.getCurrentDatamon().getHP() <= 0) {
            enemyPlayer.removeDatamon(enemyPlayer.getCurrentDatamon());

            if (!enemyPlayer.getDatamons().isEmpty()) {
                Datamon randomDatamon = enemyPlayer.getDatamons().get(random.nextInt(enemyPlayer.getDatamons().size()));
                enemyPlayer.setCurrentDatamon(randomDatamon);
            }
        }
    }

    // Checks winner by parsing NPC and Player Datamon ArrayLists.
    private Boolean checkIfWin() {
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


    // Method is called on buttons. Fight() checks winner and prompts if winner is found, checks dead datamon
    // Prompting if winner is found through method calls.
    // Finally calls Moves from button if player turn or from random number on AI turn.
    public void Fight(int pick) {
        if (enemyPlayer != null && currentPlayer != null) {
            int methodNumber;

            // Prints player and NPC datamons. Used for testing whether they get removed from lists, when datamon health <= 0;
            System.out.println("NPC Mons: " + NPC.getDatamons());
            System.out.println("Player Mons: " + player.getDatamons());

            if (!checkIfWin()) {
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


    // Picks datamon from list.
    private void chooseMon() {
        //TODO: Add måde at vælge på.
        //Generer buttons ud fra list.size() med navne på objekter.
    }


    // Swaps user on round end.
    private void switchUser() {
        if (currentPlayer.equals(player)) {
            currentPlayer = enemyPlayer;
            enemyPlayer = player;
        } else {
            currentPlayer = player;
            enemyPlayer = NPC;
        }
    }


     // Current datamon's move 1 to 4.
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
