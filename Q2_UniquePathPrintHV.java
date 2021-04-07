package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q2_UniquePathPrintHV {
    /*
    Take as input row and column of a rectangular board. The rat starts its journey
    from the top left corner and must reach the bottom-right corner to get the cheese.
    In one move the rat can move 1 step horizontally (right) or 1 step vertically
    (down).
    Write a recursive function which returns an ArrayList of moves for all valid
    paths across the board. Print the value returned.
    E.g. for a board of size 3,3; a few valid paths will be “HHVV”, “VVHH”, “VHHV” etc.
     */
    /*
    Goal: Given integers 'm' and 'n' representing m*n grid
    Find all unique paths from (0,0) to (m-1,n-1) and print them
     */
    static void printUniquePaths(int m, int n, int curr_m, int curr_n, String path) {
        if (curr_m == m && curr_n == n) {
            System.out.println(path);
            return;
        }
        if (curr_m > m || curr_n > n) {
            return;
        }
        printUniquePaths(m,n,curr_m+1,curr_n,path+"h");
        printUniquePaths(m,n,curr_m,curr_n+1,path+"v");
    }
    static int countUniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return countUniquePaths(m-1,n)+countUniquePaths(m,n-1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the row value: ");
        int row = scn.nextInt();
        System.out.print("Enter the col value: ");
        int col = scn.nextInt();
        int totalPaths = countUniquePaths(row,col);
        row--; col--;
        System.out.println("The total number of ways to reach \nfrom (0,0) to ("+row+","+col+") is "+totalPaths);
        System.out.println("The directions of these paths are:");
        printUniquePaths(++row,++col,1,1,"");
    }
}
