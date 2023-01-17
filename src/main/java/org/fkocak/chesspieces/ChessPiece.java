package org.fkocak.chesspieces;

import org.fkocak.enums.Color;
import org.fkocak.enums.Type;
import org.fkocak.mover.*;

public abstract class ChessPiece {

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    private Color color;
    private int[] position;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[][] moveableList(int[][] board, int x, int y){
        return switch (this.type){
            case PAWN -> PawnMover.pawnMover(board, x, y, color);
            case KNIGHT -> KnightMover.knightMover(board, x, y, color);
            case BISHOP -> BishopMover.bishopMover(board, x, y, color);
            case ROOK -> RookMover.rookMover(board, x, y, color);
            case QUEEN -> QueenMover.queenMover(board, x, y, color);
            case KING -> KingMover.kingMover(board, x, y, color);
        };

    }
    public ChessPiece(Type type, Color color, int[] position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

}
