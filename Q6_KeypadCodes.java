package SnehAashishGupta.Assignment5;

/*
Question:
Take as input str, a string. str represents keys pressed on a nokia phone keypad.
We are concerned with all possible words that can be written with the pressed
keys.
E.g: “12” can produce following words “ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”,
“cf”
a. Write a recursive function which returns the count of words for a given
keypad string. Print the value returned.
b. Write a recursive function which returns an ArrayList of words for a given
keypad string. Print the value returned.
c. Write a recursive function which prints all possible words for a given
keypad string (void is the return type for function).
7.
 */

/*
Solutions:
a -> https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
b -> https://www.geeksforgeeks.org/java-arraylist-to-print-all-possible-words-from-phone-digits/
c -> https://www.geeksforgeeks.org/find-possible-words-phone-digits/

Explanation:
PepCoding -> https://www.youtube.com/watch?v=3fjt19bjs3A
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Q6_KeypadCodes {
    public static String[] codes = {",;","abc","def","ghi",
    "jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        //Base Case
        if (str.length() == 0) {
            ArrayList<String> base_case = new ArrayList<>();
            base_case.add("");
            return base_case;
        }

        //Run-through: num = 678 :- 6: pqrs; 7 = tu; 8 = vwx;
        char ch = str.charAt(0);//1st - 6
        String rem_str = str.substring(1);//1st = 78

        ArrayList<String> rem_res = getKPC(rem_str);
            //Ultimately -
            // tv tw tx
            // uv uw ux
        ArrayList<String> my_res = new ArrayList<>();

        String codes4ch = codes[ch - '0'];
            //{p,q,r,s}
            //ASCII Manipulation: num_intValue = curr_num_char - '0'
        for (int i = 0; i < codes4ch.length(); i++) {
            char ch_code = codes4ch.charAt(i); //1-p 2-q 3-r 4-s
            for (String r_str : rem_res)
                my_res.add(ch_code + r_str);
                    /*
                    ptv ptw ptx
                    q ....
                    r ....
                    s ....
                     */
        }

        return my_res;
    }
    /*
    Letters and Corresponding Numbers:
    1 -> a, b, c
    2 -> d, e, f
    3 -> g, h, i
    4 -> j, k, l
    5 -> m, n, o
    6 -> p, q, r, s
    7 -> t, u
    8 -> v, w, x
    9 -> y, z
    0 -> . ;
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Key in the number: ");
        String number = scn.next();
        String num_str = String.valueOf(number);
        ArrayList<String> words = getKPC(num_str);
        System.out.println("""
                Enter the option which you want
                'a' for counting number of possible words
                'b' for printing the ArrayList of possible words
                'c' for individually printing all possible words""");
        char option = scn.next().charAt(0);
        switch (option) {
            case 'a' -> System.out.println("The number of possible combinations is: " + words.size());
            case 'b' -> System.out.println("ArrayList: " + words);
            case 'c' -> {
                System.out.println("Printing possible words line-by-line:");
                for (String word : words) {
                    System.out.println(word);
                }
            }
            default -> System.out.println("Valid Options are: 'a', 'b' and 'c'");
        }
    }
}
