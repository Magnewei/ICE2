package com.example.ice;

import java.io.IOException;
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
    private Stage userChoices = new Stage();
    private MenuController menuController = new MenuController();
    private User player = menuController.getCurrentUser();
    private User NPC = menuController.getNPC();
    private User currentPlayer = menuController.getCurrentUser();
    private User enemyPlayer = NPC;

    private Datamon currentDatamon = currentPlayer.getCurrentDatamon();
    private Datamon enemyDatamon = enemyPlayer.getCurrentDatamon();




    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Switches user between current and enemy player.
    private void switchUser() {

        if (currentPlayer.equals(player)) {
            currentPlayer = NPC;
        } else {
            currentPlayer = player;
        }

        // TODO: Fix logic with enemyPlayer
    }


    // Calls a random ability if the current player is the NPC.
    private void ChooseMove(int pick) {

       int methodNumber;

        if (currentPlayer.equals(NPC)) {
            Random random = new Random();
            methodNumber = random.nextInt(4) + 1;
            } else {
            methodNumber = pick;
        }

            switch (methodNumber) {
                case 1:
                    move1(currentDatamon, enemyDatamon);
                    break;

                case 2:
                    move2(currentDatamon, enemyDatamon);
                    break;

                case 3:
                    move3(currentDatamon, enemyDatamon);
                    break;

                case 4:
                    move4(currentDatamon, enemyDatamon);
                    break;

                default:
                    System.out.println("Something went wrong.");
        }
    }

    // Checks if the enemy players datamon is dead.
    private void checkIfDead() {
        if (!enemyPlayer.getDatamons().isEmpty() && enemyDatamon.getHP() <= 0) {
            enemyPlayer.removeDatamon(currentDatamon);
            enemyDatamon = enemyPlayer.getDatamons().get(0);
        }
    }



    private void chooseMon() {
        //TODO: Add måde at vælge på.
        //Generer buttons ud fra list.size() med navne på objekter.
    }


    // Checks if there's a winner.
    private Boolean checkIfWin() {
        if (enemyPlayer.getDatamons().size() <= 0) {
            System.out.println("Winner found test");
            return true;
        }
        return false;
    }



    public void Fight() {
        if (checkIfWin()) {
            showErrorDialog("Winner found", currentPlayer.getUsername() + "won!");

            /*
            Platform.runLater(() -> {
                try {


                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Selector.fxml"));
                    Parent root = loader.load();
                    userChoices.setScene(new Scene(root));;
                    userChoices.show();

                } catch (IOException e) {
                    showErrorDialog("Error1", "An error occurred while loading the next screen.");
                }
            });

             */

        }

        checkIfDead();
        switchUser();

    }




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

    @FXML
    public void move1Button(ActionEvent e){
        ChooseMove(1);
        Fight();
    }

    @FXML
    public void move2Button(ActionEvent e){
        ChooseMove(2);
        Fight();
    }

    @FXML
    public void move3Button(ActionEvent e){
        ChooseMove(3);
        Fight();
    }

    @FXML
    public void move4Button(ActionEvent e){
        ChooseMove(4);
        Fight();
    }

}