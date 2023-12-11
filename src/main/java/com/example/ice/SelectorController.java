package com.example.ice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.ice.Datamons.Fred2;
import com.example.ice.Datamons.Jonas;
import com.example.ice.Datamons.Kevin;
import com.example.ice.Datamons.RouvisMor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
public class SelectorController {
    private int maxCarriedDatamon = 3;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ImageView Mon1, Mon2, Mon3, Mon4, Mon5, Mon6;
    private List<Datamon> datamons = new ArrayList<>();
    private User currentUser = new User("Magnus", "");  //TODO: Replace when class is functional.
    //private User currentUser = MenuController.currentUser;                         //TODO: Remove comments from User.


    // Assigns the player datamon(s) according to buttons pressed.
    // Returns list of datamons to the BattleSimController.
    public void giveUserDatamons(Datamon datamon) {
        datamons.add(datamon);
        for(Datamon data : datamons) {
            System.out.println(data.getName());

        }
    }

    @FXML
    private void Select1Pressed(ActionEvent event) {
        Datamon datamon = new Fred2();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void  Select2Pressed(ActionEvent event) {
        Datamon datamon = new RouvisMor();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select3Pressed(ActionEvent event) {
       Datamon datamon = new Jonas();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void  Select4Pressed(ActionEvent event) {
        Datamon datamon = new Kevin();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select5Pressed(ActionEvent event) {
        //TODO: Fix assigned datamon.
       Datamon datamon = new Fred2();


        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }
    @FXML
    private void Select6Pressed(ActionEvent event) {
        //TODO: Fix assigned datamon.
        Datamon datamon = new Fred2();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void BattleButtonPressed(ActionEvent event) {
        if (datamons.size() > 0) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleSim.fxml"));
                Parent root = loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("No datamons selected.");
        }
    }

}