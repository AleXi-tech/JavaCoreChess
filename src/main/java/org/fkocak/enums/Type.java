package org.fkocak.enums;

public enum Type {
    PAWN( 1),
    KNIGHT(2),
    BISHOP(3),
    ROOK(4),
    QUEEN(5),
    KING(6);

    public final int value;
    Type(int value) {
        this.value = value;
    }

}
