package org.fkocak.chesspieces;

import org.fkocak.enums.Color;
import org.fkocak.enums.Type;

public class Pawn extends ChessPiece {
    public Pawn(Color color, int[] position) {
        super(Type.PAWN, color, position);
    }
}
