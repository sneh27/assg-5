package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q3_UniquePathPrintHVD {
    /*
    Goal: Given integers 'm' and 'n' representing an m*n grid
    Print all unique paths from (0,0) to (m-1,n-1) considering
    valid these moves:
    - Horizontal ('H') : (i,j) -> (i+1,j)
    - Vertical ('V') : (i,j) -> (i,j+1)
    - Diagonal ('D') : (i,j) -> (i+1,j+1)
     */
    static void printUniquePaths(int m, int n, int cur_m, int cur_n, String path) {
        if (cur_m > m || cur_n > n) return;
        if (cur_m == m && cur_n == n) {
            System.out.println(path);
            return;
        }
        printUniquePaths(m,n,cur_m+1,cur_n,path+"H");
        printUniquePaths(m,n,cur_m,cur_n+1,path+"V");
        printUniquePaths(m,n,cur_m+1,cur_n+1,path+"D");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the row value: ");
        int row = scn.nextInt();
        System.out.print("Enter the col value: ");
        int col = scn.nextInt();
        System.out.println("The unique paths are as follows:");
        printUniquePaths(row,col,1,1,"");
    }
}
