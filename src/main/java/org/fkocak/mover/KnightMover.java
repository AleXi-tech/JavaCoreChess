package org.fkocak.mover;

import org.fkocak.enums.Color;

import java.util.ArrayList;

public class KnightMover {
    public static int[][] knightMover(int[][] board, int x, int y, Color turn){
        ArrayList<int[]> movesKnight = new ArrayList<>();
        int[][] possibleMoves = new int[][] { {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2} };
        for (int[] move : possibleMoves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                int piece = board[newX][newY];
                if (piece == 0) {
                    movesKnight.add(new int[]{newX, newY});
                } else {
                    Color pieceColor = (piece & 1) == 0 ? Color.BLACK : Color.WHITE;
                    if (pieceColor == turn) {
                        movesKnight.add(new int[]{newX, newY});
                    }
                }
            }
        }
        int[][] resultKnight = new int[movesKnight.size()][2];
        for (int i = 0; i < movesKnight.size(); i++) {
            resultKnight[i] = movesKnight.get(i);
        }
        return resultKnight;
    }

}
