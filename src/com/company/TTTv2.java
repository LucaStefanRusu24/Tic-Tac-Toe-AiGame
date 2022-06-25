package com.company;

import java.util.Random;
import java.util.Scanner;

public class TTTv2 {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    private Board board;

    public TTTv2(){
        board = new Board();
        board.reset();
    }

    public void play(){
        int position, row = 0, column = 0, move = 1, left = 9;
        String player;

        System.out.print("Choose your token (X or O): ");
        player = scan.nextLine();
        while(!player.equalsIgnoreCase("X") && !player.equalsIgnoreCase("O")){
            System.out.print("That is not a token, please try again: ");
            player = scan.nextLine();
        }

        board.display();

        while(!board.winO() && !board.winX() && left > 0){
            if(player.equalsIgnoreCase("X")){
                if(move % 2 != 0){
                    System.out.print("Player 1, choose a spot to place X in: ");

                    move("X", "Player");
                    left--;
                }
                else if(move % 2 == 0){
                    System.out.println("The AI has placed: ");

                    move("O", "AI");
                    left--;
                }
                move++;
                board.display();
            }
            else{
                if(move % 2 != 0){
                    System.out.println("The AI has placed: ");

                    move("X", "AI");
                    left--;
                }
                else if(move % 2 == 0){
                    System.out.print("Player 2, choose a spot to place O in: ");

                    move("O", "Player");
                    left--;
                }
                move++;
                board.display();
            }
        }

        if(board.winX()){
            System.out.println("Player 1 has won, Congratulations!");
        }
        else if(board.winO()){
            System.out.println("Player 2 has won, Congratulations!");
        }
        else{
            System.out.println("The game ended in a draw");
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

    private void move(String token, String type){
        int position, row = 0, column = 0;

        if(type.equalsIgnoreCase("AI")){
            position = random.nextInt(9) + 1;
        }
        else{
            position = validIntegerInput();
            while(position > 9 || position < 1){
                System.out.println("This position does not exist on the board, please choose again");
                position = validIntegerInput();
            }
        }

        row = (position - 1) / 3;
        column = (position - 1) % 3;
        while(!board.isOpen(row, column)) {

            if (type.equalsIgnoreCase("Player")){
                System.out.println("Sorry, the place you have chosen is taken, please choose another spot!");
                position = validIntegerInput();
            }
            else{
                position = random.nextInt(9) + 1;
            }

            row = (position - 1) / 3;
            column = (position - 1) % 3;
        }

        if(token.equalsIgnoreCase("X")){
            board.placeX(row, column);
        }
        else{
            board.placeO(row, column);
        }
    }
}
