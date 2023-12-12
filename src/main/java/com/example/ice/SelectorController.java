package com.example.ice;

import java.io.IOException;
import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.ice.Datamons.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SelectorController {
    private int maxCarriedDatamon = 3;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    private MenuController menuController;
    @FXML
    private ImageView Mon1, Mon2, Mon3, Mon4, Mon5, Mon6;
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    private List<Datamon> datamons = new ArrayList<>();
    private User currentUser = menuController.getCurrentUser();
    private User NPC = menuController.getNPC();

    @FXML
    private void Select1Pressed(ActionEvent event) {
        Datamon datamon = new Fred2();
        System.out.println("Gaeshitgotrealnow");
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
        Datamon datamon = new Fred1();


        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }
    @FXML
    private void Select6Pressed(ActionEvent event) {
        Datamon datamon = new Rouvi();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }
    @FXML
    private void Select7Pressed(ActionEvent event) {
        Datamon datamon = new Bobby();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select8Pressed(ActionEvent event) {
        Datamon datamon = new Mads();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select9Pressed(ActionEvent event) {
        Datamon datamon = new Marcus();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select10Pressed(ActionEvent event) {
        Datamon datamon = new Nicolai();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select11Pressed(ActionEvent event) {
        Datamon datamon = new Tess();

        if (datamons.size() < maxCarriedDatamon) {
            datamons.add(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select12Pressed(ActionEvent event) {
        Datamon datamon = new Tobias();

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
            sendPlayerList();
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

    //public List<Datamon> sendPlayerList(){
    public void sendPlayerList() {
        for (Datamon d : datamons) {
            currentUser.addDatamon(d);
        }
    }

    public void sendNPCList(){
        Random rand = new Random();

        for(int i = 0 ; i <= datamons.size() ; i++ ) {
            List<Datamon> pickDataMon = new ArrayList<>();

            pickDataMon.add(new Bobby());
            pickDataMon.add(new Fred1());
            pickDataMon.add(new Fred2());
            pickDataMon.add(new Jonas());
            pickDataMon.add(new Kevin());
            pickDataMon.add(new Mads());
            pickDataMon.add(new Marcus());
            pickDataMon.add(new Nicolai());
            pickDataMon.add(new Rouvi());
            pickDataMon.add(new RouvisMor());
            pickDataMon.add(new Tess());
            pickDataMon.add(new Tobias());

            int randomNum = rand.nextInt(pickDataMon.size());
            NPC.addDatamon(pickDataMon.get(randomNum));
        }
    }


}