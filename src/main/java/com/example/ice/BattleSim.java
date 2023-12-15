package com.example.ice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

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
    private Datamon enemyDatamon;
    private Datamon playerDatamon;

    public void setup(User player, User NPC) {
        this.player = player;
        this.NPC = NPC;

        currentPlayer = player;
        enemyPlayer = NPC;

        enemyDatamon = enemyPlayer.getDatamons().get(0);
        playerDatamon = currentPlayer.getDatamons().get(0);
}



    // Checks if Datamon is dead.

    private void checkIfDead() {
        if (enemyDatamon.getHP() <= 0) {
            enemyPlayer.removeDatamon(enemyDatamon);
            if (!enemyPlayer.getDatamons().isEmpty()) {
                enemyDatamon = enemyPlayer.getDatamons().get(0);
            }
        }

        if (playerDatamon.getHP() <= 0) {
            player.removeDatamon(playerDatamon);
            if (!player.getDatamons().isEmpty()) {
                playerDatamon = player.getDatamons().get(0);
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

            // Used for debugging player objects and datamon arraylists.
            //System.out.println("Player datamons" + player.getDatamons().toString() );
            //System.out.println("NPC datamons" + NPC.getDatamons());
            System.out.println("CurrentPlayer is: " + currentPlayer.getUsername());
            System.out.println("CurrentPlayer is: " + enemyPlayer.getUsername());


            if (!checkIfWin()) {
                checkIfDead();

                // Execute player move
                if (currentPlayer.equals(player)) {
                    executeMove(pick, playerDatamon, enemyDatamon);
                    checkIfDead();
                    if (checkIfWin()) return;

                    switchUser(); // Switch to NPC after player move

                    // Execute NPC move
                    int npcMove = random.nextInt(1, 5); // Assuming 4 moves, inclusive
                    executeMove(npcMove, enemyDatamon, playerDatamon);
                    checkIfDead();
                    checkIfWin();

                    switchUser(); // Switch back to player
                }
            }
        }
    }




    private void switchUser() {
        User temp = currentPlayer;
        currentPlayer = enemyPlayer;
        enemyPlayer = temp;
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



    private void executeMove(int moveNumber, Datamon attacker, Datamon defender) {
        switch (moveNumber) {
            case 1:
                move1(attacker, defender);
                break;
            case 2:
                move2(attacker, defender);
                break;
            case 3:
                move3(attacker, defender);
                break;
            case 4:
                move4(attacker, defender);
                break;
            default:
                System.out.println("Invalid move.");
        }
    }

    public Datamon getPlayerDatamon(){
        return playerDatamon;
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
