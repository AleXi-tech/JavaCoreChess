package org.fkocak.mover;

import org.fkocak.enums.Color;

import java.util.ArrayList;

public class RookMover {
    public static int[][] rookMover(int[][] board, int x, int y, Color turn) {
        ArrayList<int[]> movesRook = new ArrayList<>();
        int[] dxR = {0, 0, 1, -1};
        int[] dyR = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 8; j++) {
                int newX = x + dxR[i] * j;
                int newY = y + dyR[i] * j;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    int piece = board[newX][newY];
                    if (piece == 0) {
                        movesRook.add(new int[]{newX, newY});
                    } else {
                        Color pieceColor = (piece & 1) == 0 ? Color.BLACK : Color.WHITE;
                        if (pieceColor == turn) {
                            movesRook.add(new int[]{newX, newY});
                        }
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
