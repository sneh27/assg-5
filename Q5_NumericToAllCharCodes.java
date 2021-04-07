package SnehAashishGupta.Assignment5;

import java.util.Scanner;

public class Q5_NumericToAllCharCodes {
    private static void printCharCodes(String num, String ch) {
        if (num.length() == 0) {
            System.out.println(ch);
            return;
        }
        char ch1 = num.charAt(0);
        char code = (char) (ch1 - '1' + 'a');
        printCharCodes(num.substring(1), ch + code);
        if (num.length() >= 2 && ch1 <= '2') {
            int i = Integer.parseInt(num.substring(0, 2), 10);
            if (i > 0 && i <= 26) {
                code = (char) (i + 'a' - 1);
                printCharCodes(num.substring(2), ch + code);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the numeric code: ");
        String num_code = scn.next();
        printCharCodes(num_code,"");
    }
}
