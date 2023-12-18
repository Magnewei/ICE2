package com.example.ice;

import java.util.Random;

import com.example.ice.Datamons.Shrek;
import com.example.ice.Datamons.Tobias;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class BattleSim {
    private User currentPlayer;
    private User enemyPlayer;
    private User player;
    private User NPC;
    private final Random random = new Random();
    private Datamon enemyDatamon;
    private Datamon playerDatamon;
    private String movePrint = "";

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



//Switching Users, so that currentPlayer always is the one who's about to chose a move
    private void switchUser() {
        User temp = currentPlayer;
        currentPlayer = enemyPlayer;
        enemyPlayer = temp;
    }

    // Eror catching
    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    /**
     * We are using the following method to constantly displaying what move is being used and how much damage it did in our TextBox in BattleSim.
     * @param moveNumber
     * @param attacker
     * @param defender
     */
    private void executeMove(int moveNumber, Datamon attacker, Datamon defender) {
        switch (moveNumber) {
            case 1:
                move1(attacker, defender);
                movePrint = attacker + "used move" + attacker.getMove1Name() + " on " + defender + "." + "Attack did " + attacker.getDamage() + "!";
                break;
            case 2:
                move2(attacker, defender);
                movePrint = attacker + "used move" + attacker.getMove2Name() + " on " + defender + "." + "Attack did " + attacker.getDamage() + "!";
                break;
            case 3:
                move3(attacker, defender);
                movePrint = attacker + "used move" + attacker.getMove3Name() + " on " + defender + "." + "Attack did " + attacker.getDamage() + "!";
                break;
            case 4:
                move4(attacker, defender);
                movePrint = attacker + "used move" + attacker.getMove4Name() + " on " + defender + "." + "Attack did " + attacker.getDamage() + "!";
                break;
            default:
                System.out.println("Invalid move.");
        }
    }

    public Datamon getPlayerDatamon(){
        return playerDatamon;
    }


    /**
     * These 4 methods is used to set the Defenders hp after its taken damage from the attackers move 1,2,3 and 4
     * @param attacker
     * @param defender
     */
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

    public String getMovePrint() {
        return movePrint;
    }


}
