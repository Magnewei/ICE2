package com.example.ice;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BattleSimController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button Move1, Move2, Move3, Move4, Move5, Move6, Move7, Move8;
    @FXML
    private ImageView Mon1, Mon2;


    @FXML
    void initialize() {
        assert Move2 != null : "fx:id=\"Move2\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move1 != null : "fx:id=\"Move1\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Mon1 != null : "fx:id=\"Mon1\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move4 != null : "fx:id=\"Move4\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Mon2 != null : "fx:id=\"Mon2\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move3 != null : "fx:id=\"Move3\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move6 != null : "fx:id=\"Move6\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move5 != null : "fx:id=\"Move5\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move8 != null : "fx:id=\"Move8\" was not injected: check your FXML file 'BattleSim.fxml'.";
        assert Move7 != null : "fx:id=\"Move7\" was not injected: check your FXML file 'BattleSim.fxml'.";


    }
}