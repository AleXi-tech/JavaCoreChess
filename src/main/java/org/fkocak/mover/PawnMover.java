package org.fkocak.mover;

import org.fkocak.enums.Color;

import java.util.ArrayList;

public class PawnMover {
    public static int[][] pawnMover(int[][] board, int x, int y, Color turn){
        ArrayList<int[]> movesPawn = new ArrayList<>();
        int direction = turn == Color.WHITE ? 1 : -1;
        if (board[x+direction][y] == 0) movesPawn.add(new int[]{x+direction, y});
        if (x == 1 || x == 6) {
            if (board[x+direction*2][y] == 0) movesPawn.add(new int[]{x+direction*2, y});
        }
        if (y > 0 && board[x+direction][y-1] > 0) movesPawn.add(new int[]{x+direction, y-1});
        if (y < 7 && board[x+direction][y+1] > 0) movesPawn.add(new int[]{x+direction, y+1});
        int[][] resultPawn = new int[movesPawn.size()][2];
        for (int i = 0; i < movesPawn.size(); i++) {
            resultPawn[i] = movesPawn.get(i);
        }
        return resultPawn;
    }
}
