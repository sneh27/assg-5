package SnehAashishGupta.Assignment5;

import java.util.*;

public class Q10_LexicographicallyOrderNumbers {
    static ArrayList<Integer> lexicographOrder(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            result.add(String.valueOf(i));
        }
        Collections.sort(result);
        ArrayList<Integer> result_int = new ArrayList<>();
        for (String i: result) {
            result_int.add(Integer.valueOf(i));
        }
        return result_int;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scn.nextInt();
        System.out.println(lexicographOrder(n));
        /*
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            sequence.add(i);
        }
        */
    }
}
