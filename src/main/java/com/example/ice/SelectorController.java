package com.example.ice;

import java.io.IOException;
import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.ice.Datamons.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SelectorController {
    private final int maxCarriedDatamon = 3;
    @FXML
    private ImageView Mon1, Mon2, Mon3, Mon4, Mon5, Mon6;
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    private User currentUser;
    private User NPC;
    private List<Datamon> datamons;
    private List<Datamon> NPCdatamons;


    public void setup(User currentUser, User NPC) {
        this.currentUser = currentUser;
        this.NPC = NPC;
        this.datamons = (currentUser != null) ? currentUser.getDatamons() : new ArrayList<>();
        this.NPCdatamons = (NPC != null) ? NPC.getDatamons() : new ArrayList<>();

        // Any additional setup code that depends on currentUser or NPC
    }
    @FXML
    private void Select1Pressed(ActionEvent event) {
        Datamon datamon = new Fred2();
        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void  Select2Pressed(ActionEvent event) {
        Datamon datamon = new RouvisMor();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select3Pressed(ActionEvent event) {
        Datamon datamon = new Jonas();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void  Select4Pressed(ActionEvent event) {
        Datamon datamon = new Kevin();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select5Pressed(ActionEvent event) {
        Datamon datamon = new Fred1();


        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }
    @FXML
    private void Select6Pressed(ActionEvent event) {
        Datamon datamon = new Rouvi();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }
    @FXML
    private void Select7Pressed(ActionEvent event) {
        Datamon datamon = new Bobby();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select8Pressed(ActionEvent event) {
        Datamon datamon = new Mads();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select9Pressed(ActionEvent event) {
        Datamon datamon = new Marcus();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select10Pressed(ActionEvent event) {
        Datamon datamon = new Nicolai();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select11Pressed(ActionEvent event) {
        Datamon datamon = new Tess();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }

    @FXML
    private void Select12Pressed(ActionEvent event) {
        Datamon datamon = new Tobias();

        if (datamons.size() < maxCarriedDatamon) {
            currentUser.addDatamon(datamon);
            System.out.println(datamon.getName() + " datamon added.");

        } else {
            System.out.println("You have too many datamon objects.");
        }
    }


    // Loads BattleSim
    @FXML
    private void BattleButtonPressed(ActionEvent event) {

        if (datamons.size() > 0) {
                 sendNPCList();
                 Stage userChoices = new Stage();
                try {
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleSim.fxml"));
                    Parent root = loader.load();

                    BattleSimController battleSimController = loader.getController();

                    battleSimController.setup(currentUser, NPC);

                    userChoices.setScene(new Scene(root));
                    userChoices.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

        } else {
            System.out.println("No datamons selected.");
        }
    }

     // Adds random Datamons to NPC Datamon list.
    public void sendNPCList(){
        Random rand = new Random();

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

        for(int i = 0 ; i <= (datamons.size() -1); i++ ) {
            NPC.addDatamon(pickDataMon.get(randomNum));

       }
    }

}