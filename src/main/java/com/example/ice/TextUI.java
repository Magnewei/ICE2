package com.example.ice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    private final Scanner scan = new Scanner(System.in);

    //shows a message and returns the user's input as a String
    public String getInput(String msg) {
        this.displayMessage(msg);
        return scan.nextLine();
    }


    public void displayMessage(String msg) {
        System.out.println(msg);
    }

}