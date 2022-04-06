package com.company;

import java.util.Random;
import java.util.Scanner;

public class TTTv3 {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    private Board board;

    public TTTv3(){
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
        int position = 1, row, column;

        if(type.equalsIgnoreCase("AI")){
            killerMove(token);
        }
        else{
            position = validIntegerInput();
        }

        row = (position - 1) / 3;
        column = (position - 1) % 3;
        while(!board.isOpen(row, column)) {

            if (type.equalsIgnoreCase("Player")){
                System.out.println("Sorry, the place you have chosen is taken, please choose another spot!");
                position = validIntegerInput();
            }
            else{
                killerMove(token);
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

    private void killerMove(String AIToken){
        int row, column, position;
        boolean win = false;
        if(AIToken.equalsIgnoreCase("X")){
            for(int i = 0 ; i < 9 && !win ; i++){
                row = i / 3;
                column = i % 3;
                if(board.isOpen(row, column)){
                    board.placeX(row, column);
                    if(board.winX()){
                        win = true;
                    }
                    else{
                        board.unmove(row, column);
                    }
                }
            }
            if(!win){
                for(int i = 0 ; i < 9 && !win ; i++){
                    row = i / 3;
                    column = i % 3;
                    if(board.isOpen(row, column)){
                        board.placeO(row, column);
                        if(board.winO()){
                            board.unmove(row, column);
                            board.placeX(row, column);
                            win = true;
                        }
                        else{
                            board.unmove(row, column);
                            position = random.nextInt(9) + 1;
                            row = i / 3;
                            column = i % 3;
                            board.placeO(row, column);
                        }
                    }
                }
            }
        }
        else if(AIToken.equalsIgnoreCase("O")){
            for(int i = 0 ; i < 9 && !win ; i++){
                row = i / 3;
                column = i % 3;
                if(board.isOpen(row, column)){
                    board.placeO(row, column);
                    if(board.winO()){
                        win = true;
                    }
                    else{
                        board.unmove(row, column);
                    }
                }
            }
            if(!win){
                for(int i = 0 ; i < 9 && !win ; i++){
                    row = i / 3;
                    column = i % 3;
                    if(board.isOpen(row, column)){
                        board.placeX(row, column);
                        if(board.winX()){
                            board.unmove(row, column);
                            board.placeO(row, column);
                            win = true;
                        }
                        else{
                            board.unmove(row, column);
                            position = random.nextInt(9) + 1;
                            row = i / 3;
                            column = i % 3;
                            board.placeO(row, column);
                            win = true;
                        }
                    }
                }
            }
        }
    }
}
