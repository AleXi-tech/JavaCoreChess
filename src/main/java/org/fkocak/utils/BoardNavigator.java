package org.fkocak.utils;

public class BoardNavigator {
    public static int[] boardNavigator(String input) {
        char xC = input.charAt(0);
        char yC = input.charAt(1);
        int x = -1;
        int y = switch (yC) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> -1;
        };
        switch (xC) {
            case '8' -> x = 0;
            case '7' -> x = 1;
            case '6' -> x = 2;
            case '5' -> x = 3;
            case '4' -> x = 4;
            case '3' -> x = 5;
            case '2' -> x = 6;
            case '1' -> x = 7;
        }
        return new int[] { x, y };
    }
}
