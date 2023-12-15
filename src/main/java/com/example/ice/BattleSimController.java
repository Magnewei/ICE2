package com.example.ice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



public class BattleSimController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SelectMove1, SelectMove2, SelectMove3, SelectMove4;


    @FXML
    private Button ChooseMon1,ChooseMon2,ChooseMon3;


    @FXML
    private ImageView VisualMon1, VisualMon2;


    @FXML
    private Label MoveName1, MoveName2, MoveName3, MoveName4;

    @FXML
    private Label ChooseMon1Name, ChooseMon2Name, ChooseMon3Name;

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
        MoveName1.setText(sim.getPlayerDatamon().getMove1Name());
        MoveName2.setText(sim.getPlayerDatamon().getMove2Name());
        MoveName3.setText(sim.getPlayerDatamon().getMove3Name());
        MoveName4.setText(sim.getPlayerDatamon().getMove4Name());
        ChooseMon1Name.setText(currentPlayer.getDatamons().get(0).getName());
        ChooseMon2Name.setText(currentPlayer.getDatamons().get(1).getName());
        ChooseMon3Name.setText(currentPlayer.getDatamons().get(2).getName());

    }

    //

    public void showMonButtons() {
        List<Button> buttons = new ArrayList<>();
        int amountOfDatamons = currentPlayer.getDatamons().size();

        ChooseMon1.setVisible(false);
        ChooseMon2.setVisible(false);
        ChooseMon3.setVisible(false);
        buttons.add(ChooseMon1);
        buttons.add(ChooseMon2);
        buttons.add(ChooseMon3);

        for(int i = 0; i <  amountOfDatamons ; i++){
            buttons.get(i).setVisible(true);

        }
    }


    @FXML
    public void chooseMon1(ActionEvent e){
        currentPlayer.setCurrentDatamon(0);
        System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void chooseMon2(ActionEvent e){
        currentPlayer.setCurrentDatamon(1);
        System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void chooseMon3(ActionEvent e){
        currentPlayer.setCurrentDatamon(2);
       System.out.println(currentPlayer.getCurrentDatamon());
        showMonButtons();
    }

    @FXML
    public void move1Button(ActionEvent e){
        sim.Fight(1);
        showMonButtons();
    }

    @FXML
    public void move2Button(ActionEvent e){
        sim.Fight(2);
        showMonButtons();
    }

    @FXML
    public void move3Button(ActionEvent e){
        sim.Fight(3);
        showMonButtons();
    }

    @FXML
    public void move4Button(ActionEvent e){
        sim.Fight(4);
        showMonButtons();
    }
}

