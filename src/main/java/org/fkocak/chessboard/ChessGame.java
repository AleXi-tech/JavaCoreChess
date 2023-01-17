package org.fkocak.chessboard;

import org.fkocak.enums.Color;

import java.util.Arrays;
import java.util.Scanner;

public class ChessGame {

    private static int[] currentPosition = new int[2];
    private static int[] desiredPosition = new int[2];
    private static final ChessBoard chessBoard = new ChessBoard();
    private static final Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println(chessBoard);
        while (true){
            System.out.println(chessBoard.getTurn().toString()+"'s Turn: ");
            String current = scanner.next();
            String desired = scanner.next();
            pieceMover(current, desired);
            System.out.println(chessBoard);
        }
    }

    private void pieceMover(String currentPosition, String desiredPosition){
        int[] currentPos = boardNavigator(currentPosition);
        int[] desiredPos = boardNavigator(desiredPosition);
        System.out.println(Arrays.toString(currentPos));
        System.out.println(Arrays.toString(desiredPos));
        if (chessBoard.getTurn() == Color.WHITE){
            chessBoard.setBoard(currentPos,desiredPos);
        }else if (chessBoard.getTurn() == Color.BLACK){
            chessBoard.setBoard(currentPos,desiredPos);
        }else System.err.println("ERROR");
    }

    private int[] boardNavigator(String input) {
        char xC = input.charAt(0);
        char yC = input.charAt(1);
        int x = -1;
        int y = switch (yC) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> -1;
        };
        switch (xC) {
            case '8' -> x = 0;
            case '7' -> x = 1;
            case '6' -> x = 2;
            case '5' -> x = 3;
            case '4' -> x = 4;
            case '3' -> x = 5;
            case '2' -> x = 6;
            case '1' -> x = 7;
        }
        return new int[] { x, y };
    }
}
