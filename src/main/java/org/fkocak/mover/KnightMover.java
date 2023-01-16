package org.fkocak.mover;

import java.util.ArrayList;

public class KnightMover {
    public static int[][] knightMover(int[][] board, int x, int y){
        ArrayList<int[]> movesKnight = new ArrayList<>();
        int[][] possibleMoves = new int[][] { {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2} };
        for (int[] move : possibleMoves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board[newX][newY] <= 0) {
                    movesKnight.add(new int[]{newX, newY});
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
