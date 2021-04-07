package SnehAashishGupta.Assignment5;

/*
Question:
Take an array as input and write recursive functions for the following:

a. Count the number of ways in which you can divide the array in two parts
   such that the sum of elements of both the parts will be equal. Each
   number in the array must belong to one of the two parts.

b. Print the two parts in the form of ArrayList. All possible answers should be
   printed.
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
Similar to Friends Pairing - 2 (Pepcoding)
Similar to K-Partitions (where k is 2)
    https://www.youtube.com/watch?v=TvvGj1FtHIk
Similar to Equal Sum Subset (where k is 2)
    https://www.youtube.com/watch?v=rszwy53vaP0
 */

/*
K-Partitions:

Partitioning with element can be done in two ways
    - Choosing to have non-empty set
    - Choosing to have empty set
    - Also set-wise permutations are not allowed
Ultimately all partitions with empty sets are ignored...

For E.g.: 1234
This is partitioned in the above to get:
    1234|_|_    123|4|_    124|3|_      12|34|_     12|3|4 (Allowed)
    134|2|_     .....
    Ultimately partitioning 1234 yields following non-empty sets:
    14|2|3
    1|24|3
    1|2|3|4
    1|23|4
    13|2|4
    12|3|4

Number of elements => n
Number of partitions => k
            n, k
           /    \
       n-1,k    n-1, k-1

 */

public class Q8_SplitArrayWEqualSum {
    //static int counter = 0;
    static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf, ArrayList<ArrayList<Integer>> ans) {
        if (vidx == n) {
            if (ssssf == k)
                //Check if appropriate partitions made
            {
                boolean flag = true;
                for (int i = 0; i < subsetSum.length -1; i++) {
                    if (subsetSum[i] != subsetSum[i+1]) {
                        flag = false; break;
                    }
                }
                if (flag) {
                    for(ArrayList<Integer> partition:ans) {
                        System.out.print(partition + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).size() > 0)
                //Filling non-empty sets
            {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,ssssf,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            } else
                //Filling empty sets
            {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,ssssf+1,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }
    /*
    static void k_partitions(int iter, int size, int partitions, int count, ArrayList<ArrayList<Integer>> arr) {
        if (iter > size) {
            if (count == partitions) {
                counter++;
                System.out.print(counter+".");
                for (ArrayList<Integer>set:arr) {
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < arr.size(); i++ ) {
            if (arr.get(i).size() > 0) {
                arr.get(i).add(iter);
                k_partitions(iter, size, partitions,0, arr);
                arr.get(i).remove(arr.get(i).size()-1);
            } else {
                arr.get(i).add(iter);
                k_partitions(iter+1,size,partitions,count,arr);
                arr.get(i).remove(arr.get(i).size()-1);
                break;
            }
        }
    }
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int size = scn.nextInt();
        int[] input = new int[size];
        int sum = 0;
        int partitions = 2;
        int[] subsetSum = new int[partitions];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            input[i] = scn.nextInt();
            sum += input[i];
        }
        if (partitions > size || sum%partitions != 0) {
            System.out.println(-1);
            return;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ans.add(new ArrayList<>());
        }
        //k_partitions(1,size,partitions,0,arr); -> Doing k 'partitions'
            //To partition for same sum, set_sum should be sum/k
        solution(input,0,size,partitions,subsetSum,0,ans);
    }
}
