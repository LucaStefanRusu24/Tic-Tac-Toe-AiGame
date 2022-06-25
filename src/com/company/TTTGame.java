package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TTTGame {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	    int choice;
        boolean done = false;

        while(!done){
            System.out.println("HERE ARE YOUR CHOICES: " +
                    "\n1 - PLAYER VS PLAYER" +
                    "\n2 - PLAYER VS COMPUTER (RANDOM MOVES)" +
                    "\n3 - PLAYER VS COMPUTER (KILLER MOVE)" +
                    "\n4 - PLAYER VS COMPUTER (BOARD EVALUATOR)" +
                    "\n5 - PLAYER VS COMPUTER (MINIMAX ALGORITHM)" +
                    "\n6 - QUIT");

            System.out.println("Please enter your choice: ");
            choice = validIntegerInput();

            switch(choice){
                case 1:
                    TTTv1 game1 = new TTTv1();
                    game1.play();
                    break;

                case 2:
                    TTTv2 game2 = new TTTv2();
                    game2.play();
                    break;

                case 3:
                    TTTv3 game3 = new TTTv3();
                    game3.play();
                    break;

                case 4:
                    TTTv4 game4 = new TTTv4();
                    game4.play();
                    break;

                case 5:
                    TTTv5 game5 = new TTTv5();
                    game5.play();
                    break;

                case 6:
                    done = true;
                    System.out.println("Thank you for playing tic tac toe!");
                    break;
            }
        }
    }

    static private int validIntegerInput() {      // inputs a valid floating point number
        int result = 0;
        boolean correct = false;
        while (!correct) {         // validation loop
            try {
                result = Integer.parseInt(scan.nextLine());
                correct = true;
            } catch (Exception ex) {
                System.out.print("Invalid number, try again ");
            }
        }
        return result;
    }

}
