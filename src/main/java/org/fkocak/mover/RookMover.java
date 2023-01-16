package org.fkocak.mover;

import java.util.ArrayList;

public class RookMover {
    public static int[][] rookMover(int[][] board, int x, int y){
        ArrayList<int[]> movesRook = new ArrayList<>();
        int[] dxR = {0, 0, 1, -1};
        int[] dyR = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 8; j++) {
                int newX = x + dxR[i] * j;
                int newY = y + dyR[i] * j;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    if (board[newX][newY] == 0) {
                        movesRook.add(new int[]{newX, newY});
                    } else if (board[newX][newY] > 0 && (board[newX][newY] & 1) != (board[x][y] & 1)) {
                        movesRook.add(new int[]{newX, newY});
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        int[][] resultRook = new int[movesRook.size()][2];
        for (int i = 0; i < movesRook.size(); i++) {
            resultRook[i] = movesRook.get(i);
        }
        return resultRook;
    }
}
