package org.fkocak.utils;

import org.fkocak.chesspieces.ChessPiece;
import org.fkocak.enums.Color;

import java.util.Arrays;

public class MoveValidator {

    public static boolean isValidMove(Color turn, ChessPiece[][] board, int[] currentPosition, int[] desiredPosition) {
        int[][] intBoard = BoardConverter.convertBoard(board);
        // Check if the current position is out of bounds
        if (
                currentPosition[0] < 0 ||
                        currentPosition[0] > 7 ||
                        currentPosition[1] < 0 ||
                        currentPosition[1] > 7
        ) {
            System.err.println("Current position is out of bounds!");
            return false;
        }
        // Check if the desired position is out of bounds
        if (
                desiredPosition[0] < 0 ||
                        desiredPosition[0] > 7 ||
                        desiredPosition[1] < 0 ||
                        desiredPosition[1] > 7
        ) {
            System.err.println("Desired position is out of bounds!");
            return false;
        }
        // Check if the current position is empty
        if (board[currentPosition[0]][currentPosition[1]] == null) {
            System.err.println("There is no piece at the current position!");
            return false;
        }
        // Check if the piece at the current position belongs to the current player
        if (board[currentPosition[0]][currentPosition[1]].getColor() != turn) {
            System.err.println("Selected piece does not belong to you!");
            return false;
        }
        // Check if the piece at the current position can move to the desired position
        int[][] moveableList = board[currentPosition[0]][currentPosition[1]].moveableList(intBoard, currentPosition[0], currentPosition[1]);
        System.out.println("Movable positions: "+ Arrays.deepToString(moveableList));
        boolean canMove = false;
        for (int[] ints : moveableList) {
            if (Arrays.equals(ints, desiredPosition)) {
                canMove = true;
                break;
            }
        }
        return canMove;
    }
}
