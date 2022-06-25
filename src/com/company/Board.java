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

    public void unmove(int row, int column, int number){
        myBoard[row][column] = (char) (number + 49);
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

    public boolean isMovesLeft() {
        int row, column;

        for (int i = 0; i < 9; i++){
            row = i / 3;
            column = i % 3;
            if (isOpen(row, column))
                return true;
        }
        return false;
    }

    public int evaluator(char token){
        int result = 0;
        char opp;
        if(token == 'X'){
            opp = 'O';
        }
        else{
            opp = 'X';
        }

        if ( (myBoard[0][0] != opp) && (myBoard[0][1] != opp) && (myBoard[0][2] != opp) &&
                ((myBoard[0][0] == token)||(myBoard[0][1] == token)||(myBoard[0][2] == token)) ) {
            result++;
        }

        if ( (myBoard[1][0] != opp) && (myBoard[1][1] != opp) && (myBoard[1][2] != opp) &&
                ((myBoard[1][0] == token)||(myBoard[1][1] == token)||(myBoard[1][2] == token)) ) {
            result++;
        }

        if ( (myBoard[2][0] != opp) && (myBoard[2][1] != opp) && (myBoard[2][2] != opp) &&
                ((myBoard[2][0] == token)||(myBoard[2][1] == token)||(myBoard[2][2] == token)) ) {
            result++;
        }

        if ( (myBoard[0][0] != opp) && (myBoard[1][0] != opp) && (myBoard[2][0] != opp) &&
                ((myBoard[0][0] == token)||(myBoard[1][0] == token)||(myBoard[2][0] == token)) ) {
            result++;
        }

        if ( (myBoard[0][1] != opp) && (myBoard[1][1] != opp) && (myBoard[2][1] != opp) &&
                ((myBoard[0][1] == token)||(myBoard[1][1] == token)||(myBoard[2][1] == token)) ) {
            result++;
        }

        if ( (myBoard[0][2] != opp) && (myBoard[1][2] != opp) && (myBoard[2][2] != opp) &&
                ((myBoard[0][2] == token)||(myBoard[1][2] == token)||(myBoard[2][2] == token)) ) {
            result++;
        }

        if ( (myBoard[0][0] != opp) && (myBoard[1][1] != opp) && (myBoard[2][2] != opp) &&
                ((myBoard[0][0] == token)||(myBoard[1][1] == token)||(myBoard[2][2] == token)) ) {
            result++;
        }

        if ( (myBoard[0][2] != opp) && (myBoard[1][1] != opp) && (myBoard[2][0] != opp) &&
                ((myBoard[0][2] == token)||(myBoard[1][1] == token)||(myBoard[2][0] == token)) ) {
            result++;
        }
        return result;
    }

    public int evaluatorMinimax(char token) {
        char player, opponent;

        if(token == 'X'){
            player = 'X';
            opponent = 'O';
        }
        else{
            player = 'O';
            opponent = 'X';
        }

        for (int row = 0; row < 3; row++)
        {
            if (myBoard[row][0] == myBoard[row][1] &&
                    myBoard[row][1] == myBoard[row][2])
            {
                if (myBoard[row][0] == player)
                    return +10;
                else if (myBoard[row][0] == opponent)
                    return -10;
            }
        }

        for (int column = 0; column < 3; column++)
        {
            if (myBoard[0][column] == myBoard[1][column] &&
                    myBoard[1][column] == myBoard[2][column])
            {
                if (myBoard[0][column] == player)
                    return +10;

                else if (myBoard[0][column] == opponent)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (myBoard[0][0] == myBoard[1][1] && myBoard[1][1] == myBoard[2][2])
        {
            if (myBoard[0][0] == player)
                return +10;
            else if (myBoard[0][0] == opponent)
                return -10;
        }

        if (myBoard[0][2] == myBoard[1][1] && myBoard[1][1] == myBoard[2][0])
        {
            if (myBoard[0][2] == player)
                return +10;
            else if (myBoard[0][2] == opponent)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    public int minimax(char token, int depth, boolean isMax){
        int best, row, column;
        int score = evaluatorMinimax(token);

        if(score == 10 || score == -10){
            return score;
        }
        else if(!isMovesLeft()){
            return 0;
        }

        if(isMax){
            best = -1000;
            for(int i = 0 ; i < 9 ; i++){
                row = i / 3;
                column = i % 3;

                if(isOpen(row, column)){
                    if(token == 'X'){
                        placeX(row, column);
                    }
                    else{
                        placeO(row, column);
                    }

                    best = Math.max(best, minimax(token, depth + 1, !isMax));

                    unmove(row, column, i);
                }
            }
            return best;
        }
        else{
            best = 1000;

            for(int i = 0 ; i < 9 ; i++){
                row = i / 3;
                column = i % 3;

                if(isOpen(row, column)){
                    if(token == 'X'){
                        placeO(row, column);
                    }
                    else{
                        placeX(row, column);
                    }

                    best = Math.min(best, minimax(token, depth + 1, !isMax));

                    unmove(row, column, i);
                }
            }
            return best;
        }
    }
}
