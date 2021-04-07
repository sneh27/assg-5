//PepCoding : https://www.youtube.com/watch?v=uyetDh-DyDg

package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q12_SudokoSolver {
    /*
    static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solve(int[][] board, int i, int j) {
        int ni = 0, nj = 0;
        if (j == board[0].length - 1)
            //Extreme means next i is i+1
        {
            ni = i+1;
            nj = 0;
        } else {
            ni = i;
            nj = j+1;
        }

        if (board[i][j] != 0) {
            solve(board,ni,nj);
        } else {
            for (int po = 1; po <= 9; po++) {
                if(isValid(board,i,j,po) == true) {
                    board[i][j] = po;
                    solve(board,ni,nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] sudoko = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoko[i][j] = scn.nextInt();
            }
        }
        solve(sudoko,0,0);
    }

     */
}
