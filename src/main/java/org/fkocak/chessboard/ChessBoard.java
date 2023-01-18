package org.fkocak.chessboard;

import org.fkocak.chesspieces.*;
import org.fkocak.enums.Color;
import org.fkocak.enums.Type;
import org.fkocak.utils.MoveValidator;

public class ChessBoard {
    private final ChessPiece[][] board = new ChessPiece[8][8];
    private Color turn = Color.WHITE;

    private static int[] whiteKingPosition = new int[]{0,5};
    private static int[] blackKingPosition = new int[]{7,5};
    public ChessBoard() {
        // Instantiate white pieces
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, new int[] {1, i});
        }
        board[0][0] = new Rook(Color.WHITE, new int[] {0, 0});
        board[0][1] = new Knight(Color.WHITE, new int[] {0, 1});
        board[0][2] = new Bishop(Color.WHITE, new int[] {0, 2});
        board[0][3] = new Queen(Color.WHITE, new int[] {0, 3});
        board[0][4] = new King(Color.WHITE, new int[] {0, 4});
        board[0][5] = new Bishop(Color.WHITE, new int[] {0, 5});
        board[0][6] = new Knight(Color.WHITE, new int[] {0, 6});
        board[0][7] = new Rook(Color.WHITE, new int[] {0, 7});

        // Instantiate black pieces
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, new int[] {6, i});
        }
        board[7][0] = new Rook(Color.BLACK, new int[] {7, 0});
        board[7][1] = new Knight(Color.BLACK, new int[] {7, 1});
        board[7][2] = new Bishop(Color.BLACK, new int[] {7, 2});
        board[7][3] = new Queen(Color.BLACK, new int[] {7, 3});
        board[7][4] = new King(Color.BLACK, new int[] {7, 4});
        board[7][5] = new Bishop(Color.BLACK, new int[] {7, 5});
        board[7][6] = new Knight(Color.BLACK, new int[] {7, 6});
        board[7][7] = new Rook(Color.BLACK, new int[] {7, 7});

        // Empty the rest of the squares
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    private static ChessPiece[][] copyBoard(ChessPiece[][] originalBoard) {
        ChessPiece[][] copyBoard = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(originalBoard[i], 0, copyBoard[i], 0, 8);
        }
        return copyBoard;
    }


    public void setBoard(int[] currentPosition, int[] desiredPosition) {
        if (MoveValidator.isValidMove(turn,board,currentPosition, desiredPosition)) {
            ChessPiece pieceToMove = board[currentPosition[0]][currentPosition[1]];
            board[currentPosition[0]][currentPosition[1]] = null;
            board[desiredPosition[0]][desiredPosition[1]] = pieceToMove;
            pieceToMove.setPosition(desiredPosition);
            if(pieceToMove.getType() == Type.KING) kingPositionChanger(turn,desiredPosition);
            changeTurn();
        }else System.err.println("Error on setBoard");
    }
    private void kingPositionChanger(Color turn, int[] desiredPosition){
        if (turn == Color.WHITE) whiteKingPosition = desiredPosition;
        else blackKingPosition = desiredPosition;
    }

    private boolean isKingInCheck(Color turn, ChessPiece[][] board) {
        Color oppositeColor = (turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
        int[] kingPosition = (turn == Color.WHITE) ? whiteKingPosition : blackKingPosition;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j].getColor() == oppositeColor) {
                    // check if the opponent's piece has a valid move to the current player's king
                    if (MoveValidator.isValidMove(oppositeColor, board, new int[] {i, j}, kingPosition)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isKingSafe(Color turn) {
        int[] kingPosition = (turn == Color.WHITE) ? whiteKingPosition : blackKingPosition;
        int x = kingPosition[0];
        int y = kingPosition[1];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    //create a copy of the board
                    ChessPiece[][] copyBoard = copyBoard(board);
                    //make the move on the copy board
                    copyBoard[x][y] = null;
                    copyBoard[newX][newY] = new King(turn, new int[]{newX, newY});
                    // check if the king is in check after making that move
                    if (!isKingInCheck(turn, copyBoard)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

    public Color getTurn() {
        return turn;
    }

    public void changeTurn() {
        if (turn==Color.WHITE) turn = Color.BLACK;
        else turn = Color.WHITE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   A  B  C  D  E  F  G  H\n");
        for (int i = 0; i < 8; i++) {
            sb.append(8 - i).append(" ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece == null) {
                    sb.append(" . ");
                } else {
                    String pieceName = piece.getType().name().substring(0, 1);
                    String color = piece.getColor() == Color.WHITE ? "w" : "b";
                    sb.append(color).append(pieceName).append(" ");
                }
            }
            sb.append(8 - i).append("\n");
        }
        sb.append("   A  B  C  D  E  F  G  H\n");
        return sb.toString();
    }

}
