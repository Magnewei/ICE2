package com.example.ice;


import java.util.Random;
import com.example.ice.Datamons.Fred2;
import com.example.ice.Datamons.Jonas;
import com.example.ice.Datamons.Kevin;
import com.example.ice.Datamons.RouvisMor;

public class BattleSimController {
    DBConnector db = new DBConnector();
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
        player.addDatamon(kevin);
        player.addDatamon(jonas);
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


            if(pressedAttackButton){
                attack(currentPlayer1Mon,currentNPCMon);
            }else if(pressedSwitchButton){
              //  currentPlayer1Mon = switchMons();  //TODO: Fjern kommentar når funktion testes.
            }

            //Checks if NPC Datamon is alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentNPCMon)){
                NPC.removeDatamon(currentNPCMon);
                currentNPCMon = NPC.getDatamons().get(random.nextInt(0,NPC.getDatamons().size()));
            }

            //Checks if Player Datamon is alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentPlayer1Mon)){
                player.removeDatamon(currentPlayer1Mon);
                currentPlayer1Mon = player.getDatamons().get(0);
            }

            //NPC turn
            attack(currentNPCMon,currentPlayer1Mon);

            //Checks if NPC Datamon is alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentNPCMon)){
                NPC.removeDatamon(currentNPCMon);
                currentNPCMon = NPC.getDatamons().get(random.nextInt(0,NPC.getDatamons().size()));
            }

            //Checks if Player Datamon is alive. If not, subs in  a new one. If it was the last one, awards a win.
            if(checkIfDead(currentPlayer1Mon)){
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

    public void attack(Datamon attacker, Datamon defender){
        defender.setHP((int) (defender.getHP() - attacker.DamageBuff(defender)));
    }

    public void switchMons(){
        //TODO Skal vælges via knap
        Datamon denDerBlirValgt = jonas;  // Fjern efter test
        currentPlayer1Mon = denDerBlirValgt;
    }

    public boolean checkIfDead(Datamon d){
        return d.getHP() <= 0;
    }



}