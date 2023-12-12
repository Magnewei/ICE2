package com.example.ice;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.ice.Datamons.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BattleSimController {
    DBConnector db = new DBConnector();
    SelectorController sc = new SelectorController();
    Kevin kevin = new Kevin();
    Jonas jonas = new Jonas();
    RouvisMor rouvisMor = new RouvisMor();
    Fred2 fred2 = new Fred2();
    User player = new User("Anton","123");
    User NPC = new User("Hal9000","ImSorryDave");
    TextUI ui = new TextUI();
    Random random = new Random();
    Datamon currentPlayer1Mon;
    Datamon currentPlayer2Mon;
    Datamon currentNPCMon;




    public void FightNPC(){
        //TODO Skal bare sættes til at hente lister fra SelectorController?
        List<Datamon> selected = sc.sendList();
        for(Datamon d:selected){
            player.addDatamon(d);
        }
        NPC.addDatamon(rouvisMor);
        NPC.addDatamon(fred2);

        //TODO Skal vælges via knap
        currentPlayer1Mon = player.getDatamons().get(0);

        //Kun sat her for at fjerne debugging fejl.
        boolean pressedAttackButton = true;
        boolean pressedSwitchButton = true;


        currentNPCMon = NPC.getDatamons().get(random.nextInt(0,NPC.getDatamons().size()));

        while(player.getDatamons().size() > 0 && NPC.getDatamons().size() > 0){
            //Players turn
            ui.displayMessage("Do you want to attack or switch?");


            //TODO skal vælge move via knap.


            //Checks if Datamons are alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentNPCMon)){
                NPC.removeDatamon(currentNPCMon);
                currentNPCMon = NPC.getDatamons().get(random.nextInt(0,NPC.getDatamons().size()));
            } else if (checkIfDead(currentPlayer1Mon)){
                player.removeDatamon(currentPlayer1Mon);
                currentPlayer1Mon = player.getDatamons().get(0);
            }

            //NPC turn
            //attack(currentNPCMon,currentPlayer1Mon);

            //Checks if Datamons are alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentNPCMon)){
                NPC.removeDatamon(currentNPCMon);
                currentNPCMon = NPC.getDatamons().get(random.nextInt(0,NPC.getDatamons().size()));
            } else if (checkIfDead(currentPlayer1Mon)){
                player.removeDatamon(currentPlayer1Mon);
                currentPlayer1Mon = player.getDatamons().get(0);
            }

        }

        if (player.getDatamons().size() > 0){
            //Player wins
        }else{
            //NPC wins
        }

    }

    public void move1(Datamon attacker, Datamon defender) {
        defender.setHP((int) (defender.getHP() - attacker.move1(defender)));
    }
    public void move2(Datamon attacker, Datamon defender) {
        defender.setHP((int) (defender.getHP() - attacker.move1(defender)));
    }
    public void move3(Datamon attacker, Datamon defender) {
        defender.setHP((int) (defender.getHP() - attacker.move1(defender)));
    }
    public void move4(Datamon attacker, Datamon defender) {
        defender.setHP((int) (defender.getHP() - attacker.move1(defender)));
    }

    @FXML
    public void move1Button(ActionEvent e){
       move1(currentPlayer1Mon,currentNPCMon);
    }

    @FXML
    public void move2Button(ActionEvent e){
        move2(currentPlayer1Mon,currentNPCMon);
    }

    @FXML
    public void move3Button(ActionEvent e){
        move3(currentPlayer1Mon,currentNPCMon);
    }

    @FXML
    public void move4Button(ActionEvent e){
        move4(currentPlayer1Mon,currentNPCMon);
    }

    public void switchMons(){
        //TODO Skal vælges via knap
        Datamon denDerBlirValgt = jonas;  // Fjern efter test
        currentPlayer1Mon = denDerBlirValgt;
    }

    public boolean checkIfDead(Datamon d){
        return d.getHP() <= 0;
    }

    public List<Datamon> makeAll(){
        List<Datamon> all = new ArrayList<>();
        Datamon d1 = new Bobby();
        all.add(d1);
        Datamon d2 = new Fred2();
        all.add(d1);
        Datamon d3 = new Jonas();
        all.add(d1);
        Datamon d4 = new Kevin();
        all.add(d1);
        Datamon d5 = new Mads();
        all.add(d1);
        Datamon d6 = new Marcus();
        all.add(d1);
        Datamon d7 = new Nicolai();
        all.add(d1);
        Datamon d8 = new Rouvi();
        all.add(d1);
        Datamon d9 = new RouvisMor();
        all.add(d1);
        Datamon d10 = new Tess();
        all.add(d1);
        Datamon d11 = new Tobias();
        all.add(d1);
        Datamon d12 = new Bobby();
        all.add(d1);
          return null;
    }



}