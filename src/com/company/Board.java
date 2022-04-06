package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Board {
    private char[][] myBoard;

    public Board(){
        myBoard = new char[3][3];
    }

    public void reset(){
        int row, column;
        char character;
        for(int i = 0 ; i < 9 ; i++){
            row = i / 3;
            column = i % 3;
            character = (char)(i+49);
            myBoard[row][column] = character;
        }
    }

    public void display(){
        System.out.println("+---+---+---+");
        System.out.println("| " + myBoard[0][0] + " | " + myBoard[0][1] + " | " + myBoard[0][2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + myBoard[1][0] + " | " + myBoard[1][1] + " | " + myBoard[1][2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + myBoard[2][0] + " | " + myBoard[2][1] + " | " + myBoard[2][2] + " |");
        System.out.println("+---+---+---+");
    }

    public void placeO(int row, int column){
        myBoard[row][column] = 'O';
    }

    public void placeX(int row, int column){
        myBoard[row][column] = 'X';
    }

    public void unmove(int row, int column){
        myBoard[row][column] = (char) ((row * 3) + 49);
    }

    public boolean isOpen(int row, int column){
        boolean result = true;
        if(myBoard[row][column] == 'O' || myBoard[row][column] == 'X'){
            result = false;
        }
        return result;
    }

    public boolean winO(){
        boolean result = false;
        // Check rows
        if (myBoard[0][0] == 'O' && myBoard[0][1] == 'O' && myBoard[0][2] == 'O') { result = true; }
        if (myBoard[1][0] == 'O' && myBoard[1][1] == 'O' && myBoard[1][2] == 'O') { result = true; }
        if (myBoard[2][0] == 'O' && myBoard[2][1] == 'O' && myBoard[2][2] == 'O') { result = true; }
        //Check columns
        if (myBoard[0][0] == 'O' && myBoard[1][0] == 'O' && myBoard[2][0] == 'O') { result = true; }
        if (myBoard[0][1] == 'O' && myBoard[1][1] == 'O' && myBoard[2][1] == 'O') { result = true; }
        if (myBoard[0][2] == 'O' && myBoard[1][2] == 'O' && myBoard[2][2] == 'O') { result = true; }
        //Check diagonals
        if (myBoard[0][0] == 'O' && myBoard[1][1] == 'O' && myBoard[2][2] == 'O') { result = true; }
        if (myBoard[0][2] == 'O' && myBoard[1][1] == 'O' && myBoard[2][0] == 'O') { result = true; }

        return result;
    }

    public boolean winX(){
        boolean result = false;
        // Check rows
        if (myBoard[0][0] == 'X' && myBoard[0][1] == 'X' && myBoard[0][2] == 'X') { result = true; }
        if (myBoard[1][0] == 'X' && myBoard[1][1] == 'X' && myBoard[1][2] == 'X') { result = true; }
        if (myBoard[2][0] == 'X' && myBoard[2][1] == 'X' && myBoard[2][2] == 'X') { result = true; }
        //Check columns
        if (myBoard[0][0] == 'X' && myBoard[1][0] == 'X' && myBoard[2][0] == 'X') { result = true; }
        if (myBoard[0][1] == 'X' && myBoard[1][1] == 'X' && myBoard[2][1] == 'X') { result = true; }
        if (myBoard[0][2] == 'X' && myBoard[1][2] == 'X' && myBoard[2][2] == 'X') { result = true; }
        //Check diagonals
        if (myBoard[0][0] == 'X' && myBoard[1][1] == 'X' && myBoard[2][2] == 'X') { result = true; }
        if (myBoard[0][2] == 'X' && myBoard[1][1] == 'X' && myBoard[2][0] == 'X') { result = true; }

        return result;
    }
}
