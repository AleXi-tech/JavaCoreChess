package org.fkocak.chessboard;

import org.fkocak.enums.Color;

import java.util.Scanner;

public class ChessGame {

    private static int[] currentPosition = new int[2];
    private static int[] desiredPosition = new int[2];
    private static final ChessBoard chessBoard = new ChessBoard();
    private static final Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println(chessBoard);
        while (true){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            pieceMover(new int[]{x1, y1}, new int[]{x2, y2});
            System.out.println(chessBoard);
        }
    }

    private void pieceMover(int[] currentPosition, int[] desiredPosition){
        if (chessBoard.getTurn() == Color.WHITE){
            chessBoard.setBoard(currentPosition,desiredPosition);

        }else if (chessBoard.getTurn() == Color.BLACK){
            chessBoard.setBoard(currentPosition,desiredPosition);
        }else System.err.println("ERROR");
    }

}
