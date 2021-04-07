package SnehAashishGupta.Assignment5;

import java.util.*;
import java.lang.*;
/*
Solution Link (C++) - https://ide.codingblocks.com/s/79789?_ga=2.160172733.1645887682.1616553370-309171560.1616197584
Solution Link (Java) - https://ide.codingblocks.com/s/162141?_ga=2.4853043.1645887682.1616553370-309171560.1616197584
 */
public class Q4_UniquePathwObstacle {
    public static boolean searchPath(char[][] maze, int n, int m, int x, int y, int[][] path) {
        if (x < 0 || x >= n || y < 0 || y >= m) {// this for if we get outside the matrix
            return false;
        }

        if (x == n - 1 && y == m - 1) {// this for reaching the end cell
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }

            return true;
        }

        if (maze[x][y] == 'X' || path[x][y] == 1) {// if zero occurs then move back ya phir agr koi path hum follow kr
            // chuke h toh usspe p bhi nhi jaa sakte hum
            return false;
        }

        path[x][y] = 1;// yeh isliye likha h matlb ki pichle pe hum phoch chuke h , ab agle ke liye
        // check kr rahe h
        // right
        if (searchPath(maze, n, m, x, y + 1, path)) {
            path[x][y] = 0;
            return true;
        }

        // left
        if (searchPath(maze, n, m, x, y - 1, path)) {
            path[x][y] = 0;
            return true;
        }

        // top
        if (searchPath(maze, n, m, x - 1, y, path)) {
            path[x][y] = 0;
            return true;
        }

        // down
        if (searchPath(maze, n, m, x + 1, y, path)) {
            path[x][y] = 0;
            return true;
        }
        path[x][y] = 0;
        return false;
    }
    public static boolean findPath(char[][] maze, int row, int col) {
        int[][] path = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int  j = 0; j < col; j++) {
                path[i][j] = 0;
            }
        }
        return searchPath(maze, row, col, 0, 0, path);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        char[][] maze = new char[row][col];
        for (int curr_row = 0; curr_row < row; curr_row++) {
            String str = scn.next();
            for (int curr_col = 0; curr_col < col; curr_col++) {
                maze[curr_row][curr_col] = str.charAt(curr_col);
            }
        }
        if (!findPath(maze, row, col)) {
            System.out.println("NO PATH FOUND");
        }
    }
}
