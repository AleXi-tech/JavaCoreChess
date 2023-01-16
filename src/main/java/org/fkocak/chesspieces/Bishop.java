package org.fkocak.chesspieces;

import org.fkocak.enums.Color;
import org.fkocak.enums.Type;

public class Bishop extends ChessPiece {
    public Bishop(Color color, int[] position) {
        super(Type.BISHOP, color, position);
    }
}
