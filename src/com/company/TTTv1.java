package com.company;

import java.util.Scanner;

public class TTTv1 {

    static Scanner scan = new Scanner(System.in);

    private Board board;

    public TTTv1(){
        board = new Board();
        board.reset();
    }

    public void play(){
        int position, row = 0, column = 0, move = 1, left = 9;

        board.display();

        while(!board.winO() && !board.winX() && left > 0){

            if(move % 2 != 0){
                System.out.print("Player 1, choose a spot to place X in: ");

                move("X");
                left--;
            }
            else if(move % 2 == 0){
                System.out.print("Player 2, choose a spot to place O in: ");

                move("O");
                left--;
            }
            move++;
            board.display();
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

    private void move(String token){
        int position, row = 0, column = 0;
        position = validIntegerInput();
        while(position > 9 || position < 1){
            System.out.println("This position does not exist on the board, please choose again");
            position = validIntegerInput();
        }
        row = (position - 1) / 3;
        column = (position - 1) % 3;
        while(!board.isOpen(row, column)){
            System.out.println("Sorry, the place you have chosen is taken, please choose another spot!");
            position = validIntegerInput();
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
