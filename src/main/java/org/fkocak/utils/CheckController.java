package org.fkocak.utils;

import org.fkocak.enums.Color;
import org.fkocak.mover.*;

public class CheckController {
    public static int[][] isChecked(int[][] board, Color turn) {
        int[] kingPos = new int[2];
        // Find the king's position on the board
        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0) {
                    if ((board[i][j] & 1) == (turn != Color.WHITE ? 0 : 1)) {
                        if (board[i][j] == 6 || board[i][j] == -6) {
                            kingPos[0] = i;
                            kingPos[1] = j;
                            break outerloop;
                        }
                    }
                }
            }
        }

        // Calculate the possible moves for the king
        int[][] possibleMoves = KingMover.kingMover(board, kingPos[0], kingPos[1], turn);

        // Check if any of the opponent's pieces can move to the king's position
//        for (int[] move : possibleMoves) {
//            if (board[move[0]][move[1]] != 0) {
//                if ((board[move[0]][move[1]] & 1) != (turn == Color.WHITE ? 0 : 1)) {
//                    return true;
//                }
//            }
//        }
        return possibleMoves;
    }
}

                            
