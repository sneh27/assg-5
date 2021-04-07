package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q1_RemoveXFrmStr {
    /*
    Take as input str, a string. Write a recursive function which moves all ‘x’ from the
    string to its end. Print the value returned
    E.g. for “abexexdexed” return “abeedeedxxx”.
     */
    static String removeChar(String str, char rem) {
        if (str.length() == 0) return "";
        if (str.charAt(0) == rem) {
            return removeChar(str.substring(1),rem);
        }
        return str.charAt(0) + removeChar(str.substring(1),rem);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scn.nextLine();
        char remove = 'x';
        String result = removeChar(input,remove);
        System.out.println("The string after removing all occurrences of 'x' is: "+result);
    }
}
