package org.fkocak.utils;

import org.fkocak.chesspieces.ChessPiece;

public class BoardConverter {
    public static int[][] convertBoard(ChessPiece[][] chessBoard) {
        int[][] intBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == null) {
                    intBoard[i][j] = 0;
                } else {
                    intBoard[i][j] = chessBoard[i][j].getType().value;
                }
            }
        }
        return intBoard;
    }
}
