package org.fkocak.mover;

import java.util.ArrayList;

public class QueenMover {
    public static int[][] queenMover(int[][] board, int x, int y){
        ArrayList<int[]> movesQueen = new ArrayList<>();
        int[] dxQ = {1, 1, -1, -1, 0, 0, 1, -1};
        int[] dyQ = {1, -1, 1, -1, 1, -1, 0, 0};
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                int newX = x + dxQ[i] * j;
                int newY = y + dyQ[i] * j;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    if (board[newX][newY] == 0) {
                        movesQueen.add(new int[]{newX, newY});
                    } else if (board[newX][newY] > 0 && (board[newX][newY] & 1) != (board[x][y] & 1)) {
                        movesQueen.add(new int[]{newX, newY});
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        int[][] resultQueen = new int[movesQueen.size()][2];
        for (int i = 0; i < movesQueen.size(); i++) {
            resultQueen[i] = movesQueen.get(i);
        }
        return resultQueen;
    }
}
