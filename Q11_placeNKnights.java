//GFG: https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/
package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q11_placeNKnights {
    static int m, n, k;
    static int count;

    static void makeBoard(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '_';
            }
        }
    }

    static void kkn(int k, int sti, int stj, char[][] board) {
        if (k == 0) {
            displayBoard(board);
            count++;
        } else {
            for (int i = sti; i < m; i++) {
                for (int j = stj; j < n; j++) {
                    if (canPlace(i,j,board)) {
                        char[][] new_board = new char[m][n];
                        for (int x = 0; x < m; x++) {
                            new_board[x] = new char[n];
                        }
                        place(i,j,'K','A',board,new_board);
                        kkn(k-1,i,j,new_board);
                    }
                }
                stj = 0;
            }
        }
    }

    static void displayBoard(char[][] board) {
        for (int i = 0; i < m; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean canPlace(int i, int j, char[][] board) {
        return board[i][j] == '_';
    }

    static void place(int i, int j, char k, char a, char[][] board, char[][] new_board) {
        for (int x = 0; x < m; x++) {
            if (n >= 0) System.arraycopy(board[x], 0, new_board[x], 0, n);
        }
        new_board[i][j] = k;
        attack(i, j, a, new_board);
    }

    static void attack(int i, int j, char a, char[][]board) {
        if ((i + 2) < m && (j - 1) >= 0) {
            board[i + 2][j - 1] = a;
        }
        if ((i - 2) >= 0 && (j - 1) >= 0) {
            board[i - 2][j - 1] = a;
        }
        if ((i + 2) < m && (j + 1) < n) {
            board[i + 2][j + 1] = a;
        }
        if ((i - 2) >= 0 && (j + 1) < n) {
            board[i - 2][j + 1] = a;
        }
        if ((i + 1) < m && (j + 2) < n) {
            board[i + 1][j + 2] = a;
        }
        if ((i - 1) >= 0 && (j + 2) < n) {
            board[i - 1][j + 2] = a;
        }
        if ((i + 1) < m && (j - 2) >= 0) {
            board[i + 1][j - 2] = a;
        }
        if ((i - 1) >= 0 && (j - 2) >= 0) {
            board[i - 1][j - 2] = a;
        }
    }
    /*
                   ? // Delete the new board to free up the memory
                        for (int x = 0; x < m; x++) {
                            delete[] new_board[x];
                        }
                        delete[] new_board;
                   ?

     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the dimension of chess board: ");
        m = scn.nextInt();
        n = m;
        k = m;
        count = 0;
        char[][] board = new char[m][n];
        makeBoard(board);
        kkn(k,0,0,board);
        System.out.println();
        System.out.println("Total number of solutions: "+count);
    }
}