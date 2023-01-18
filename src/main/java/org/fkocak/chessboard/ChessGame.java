package org.fkocak.chessboard;

import org.fkocak.utils.BoardNavigator;

import java.util.Arrays;
import java.util.Scanner;

public class ChessGame {
    private static final ChessBoard chessBoard = new ChessBoard();
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(chessBoard);

        //if (CheckController.isChecked(intBoard,turn)){
        //System.out.println("CHECKED!");
        //}
        while (true) {
            System.out.println(chessBoard.getTurn().toString() + "'s Turn: ");
            //int[][] intBoard = BoardConverter.convertBoard(chessBoard.getBoard());
            //Color turn = chessBoard.getTurn();
            //System.out.println(chessBoard.getTurn().toString()+"'s King Movables: "+ Arrays.deepToString(CheckController.isChecked(intBoard, turn)));
            String current = scanner.next();
            String desired = scanner.next();
            pieceMover(current, desired);
            System.out.println(chessBoard);
        }
    }

    private void pieceMover(String currentPosition, String desiredPosition) {
        int[] currentPos = BoardNavigator.boardNavigator(currentPosition);
        int[] desiredPos = BoardNavigator.boardNavigator(desiredPosition);
        System.out.println(Arrays.toString(currentPos));
        System.out.println(Arrays.toString(desiredPos));
        chessBoard.setBoard(currentPos, desiredPos);

    }
}
