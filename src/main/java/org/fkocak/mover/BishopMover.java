package org.fkocak.mover;

import org.fkocak.enums.Color;

import java.util.ArrayList;

public class BishopMover {
    public static int[][] bishopMover(int[][] board, int x, int y, Color turn){
        ArrayList<int[]> movesBishop = new ArrayList<>();
        int[] dxB = {1, 1, -1, -1};
        int[] dyB = {1, -1, 1, -1};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 8; j++) {
                int newX = x + dxB[i] * j;
                int newY = y + dyB[i] * j;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    int piece = board[newX][newY];
                    if (piece == 0) {
                        movesBishop.add(new int[]{newX, newY});
                    } else {
                        Color pieceColor = (piece & 1) == 0 ? Color.BLACK : Color.WHITE;
                        if (pieceColor == turn) {
                            movesBishop.add(new int[]{newX, newY});
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        int[][] resultBishop = new int[movesBishop.size()][2];
        for (int i = 0; i < movesBishop.size(); i++) {
            resultBishop[i] = movesBishop.get(i);
        }
        return resultBishop;
    }

}
