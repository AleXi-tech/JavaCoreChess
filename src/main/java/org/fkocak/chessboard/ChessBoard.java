package org.fkocak.chessboard;

import org.fkocak.chesspieces.*;
import org.fkocak.enums.Color;

import java.util.Arrays;

public class ChessBoard {
    private final ChessPiece[][] board = new ChessPiece[8][8];
    private Color turn = Color.WHITE;

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

    private int[][] convertBoard(ChessPiece[][] chessBoard) {
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
        System.err.println(Arrays.deepToString(intBoard));
        return intBoard;
    }


    public boolean isValidMove(int[] currentPosition, int[] desiredPosition) {
        int[][] intBoard = convertBoard(board);
        // Check if the current position is out of bounds
        if (
                currentPosition[0] < 0 ||
                currentPosition[0] > 7 ||
                currentPosition[1] < 0 ||
                currentPosition[1] > 7
        ) {
            return false;
        }
        // Check if the desired position is out of bounds
        if (
                desiredPosition[0] < 0 ||
                desiredPosition[0] > 7 ||
                desiredPosition[1] < 0 ||
                desiredPosition[1] > 7
        ) {
            return false;
        }
        // Check if the current position is empty
        if (board[currentPosition[0]][currentPosition[1]] == null) {
            return false;
        }
        // Check if the piece at the current position belongs to the current player
        if (board[currentPosition[0]][currentPosition[1]].getColor() != turn) {
            return false;
        }
        // Check if the piece at the current position can move to the desired position
        int[][] moveableList = board[currentPosition[0]][currentPosition[1]].moveableList(intBoard, currentPosition[0], currentPosition[1]);
        System.err.println(Arrays.deepToString(moveableList));
        boolean canMove = false;
        for (int[] ints : moveableList) {
            if (Arrays.equals(ints, desiredPosition)) {
                canMove = true;
                break;
            }
        }
        return canMove;
    }

    public void setBoard(int[] currentPosition, int[] desiredPosition) {
        if (isValidMove(currentPosition, desiredPosition)) {
            ChessPiece pieceToMove = board[currentPosition[0]][currentPosition[1]];
            board[currentPosition[0]][currentPosition[1]] = null;
            board[desiredPosition[0]][desiredPosition[1]] = pieceToMove;
            pieceToMove.setPosition(desiredPosition);
            changeTurn();
        }else System.err.println("Error on setBoard");
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
