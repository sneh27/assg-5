package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q11_NKnights {
    public static boolean IsKnightSafe(boolean[][] board, int i, int j) {
        if (i - 1 >= 0 && j - 2 >= 0 && board[i-1][j-2]) {
            return false;
        }
        if (i - 2 >= 0 && j - 1 >= 0 && board[i-2][j-1]) {
            return false;
        }
        if (i - 2 >= 0 && j + 1 < board.length && board[i-2][j+1]) {
            return false;
        }
        return true;
    }
    public static void nKnights(int kpsf, int tk, boolean[][] board, int cell_val)
        /*
        kpsf -> Knight pos so far
        tk -> Total Knights (Equal to n)
        cell_val -> Current Value of Knight getting filled
         */
    {
        if (kpsf == tk) {
            for (boolean[] booleans : board) {
                for (int col = 0; col < board.length; col++) {
                    System.out.print(booleans[col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = cell_val + 1; i < board.length * board.length; i++ ) {
            int row = i / board.length;
            int col = i / board.length;

            if (!board[row][col] && IsKnightSafe(board, row, col)) {
                board[row][col] = true;
                nKnights(kpsf+1,tk,board,row*board.length+col);
                board[row][col] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the chess board: ");
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        nKnights(0,n,board,-1);
        /*
        Cell Position in 2D matrix trick:-
        cell_value = row*square + col
        row_value = cell_value/square
        col_value = cell_value/square
         */
        /*
        For N-Knights:
        Condition for safety of knight at cell at [i,j]
        is following cells should be unfilled:
            [i-2,j-1]
            [i-1,j-2]
            [i-2,j+1]
            [i-1,j+2]
         */

    }
}
