package SnehAashishGupta.Assignment5;

/*
Question:
Take as input str, a string. We are concerned
with all possible permutations of
characters in str.
E.g. “abc” can produce following words “abc”,
     “acb”, “bac”, “bca”, “cab”, “cba”
a. Write a recursive function which returns the
   count of different permutations for a given
   string. Print the value returned.
   Solution:- https://www.geeksforgeeks.org/number-distinct-permutation-string-can/

b. Write a recursive function which returns an
   ArrayList of permutations for a given string.
   Print the value returned.
   Solution:- https://www.geeksforgeeks.org/print-all-permutation-of-a-string-using-arraylist/

c. Write a recursive function which prints all
   possible permutations for a given string
   (void is the return type for function).
   Solution:- https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Q7_Permutations {
    static final int MAX_CHAR = 26;
    //static final int modulo = 100000007; //Largest Prime Number in 'int' range
        //Total Distinct Characters
        //Assuming lowercase input only

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
    static void printPermutations(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                printPermutations(str,l+1,r);
                str = swap(str,l,i);
            }
        }
    }
    static void printArrayList(ArrayList<String> arrL) {
        arrL.remove("");
        for (String s : arrL) {
            System.out.print(s + " ");
        }
    }
    static ArrayList<String> getPermutation(String str) {
        if (str.length() == 0) {
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        char ch = str.charAt(0);
        String rem_str = str.substring(1);
        ArrayList<String> rem_res = getPermutation(rem_str);
        ArrayList<String> res = new ArrayList<>();
        for (String curr_str:rem_res) {
            for (int i = 0; i <= curr_str.length(); i++) {
                res.add(curr_str.substring(0,i) + ch + curr_str.substring(i));
            }
        }
        return res;
    }

    static int factorial (int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact = fact*i;
        return fact;
    }
    static int countDistinctPermutations(String str) {
        int len = str.length();
        int[] freq = new int[MAX_CHAR];
            //Frequency array tracking each letter of string
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) >= 'a') {
                freq[str.charAt(i) - 'a']++;
            }
        }
        int fact = 1;
        for (int i = 0; i < MAX_CHAR; i++) {
            fact = fact*factorial(freq[i]);
        }
        return factorial(len)/fact;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string:- ");
        String permute = scn.next();

        System.out.println("""
                Enter the option which you want
                'a' for counting number of permutations
                'b' for printing the ArrayList of permutations
                'c' for individually printing all possible words""");

        char option = scn.next().charAt(0);
        switch (option) {
            case 'a' -> {
                int count = countDistinctPermutations(permute);
                System.out.println("The number of possible permutations is: " + count);
            }
            case 'b' -> {
                System.out.print("ArrayList: ");
                printArrayList(getPermutation(permute));
            }
            case 'c' -> {
                System.out.println("Printing possible permutations line-by-line:");
                printPermutations(permute,0,permute.length()-1);
            }
            default -> System.out.println("Valid Options are: 'a', 'b' and 'c'");
        }
    }
}

