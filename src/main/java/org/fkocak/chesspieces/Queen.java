package org.fkocak.chesspieces;

import org.fkocak.enums.Color;
import org.fkocak.enums.Type;

import java.util.ArrayList;

public class Queen extends ChessPiece {
    public Queen(Color color, int[] position) {
        super(Type.QUEEN, color, position);
    }
}
