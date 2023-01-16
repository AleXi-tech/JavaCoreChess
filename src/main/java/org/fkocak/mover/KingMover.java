package org.fkocak.mover;

import java.util.ArrayList;

public class KingMover {
    public static int[][] kingMover(int[][] board, int x, int y){
        ArrayList<int[]> moves = new ArrayList<>();
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board[newX][newY] <= 0) {
                    moves.add(new int[]{newX, newY});
                }
            }
        }
        int[][] result = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            result[i] = moves.get(i);
        }
        return result;
    }
}
