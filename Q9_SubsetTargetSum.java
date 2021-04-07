package SnehAashishGupta.Assignment5;

import java.util.Scanner;
import java.util.Vector;

public class Q9_SubsetTargetSum {
    static int subsetSumTargetCount(int[] arr, int n, int i, int sum, int count) {
        if (i == n)
            //All elements counted...
        {
            if (sum == 0) count++; //Empty set is also a set
            return count;
        }
        count = subsetSumTargetCount(arr, n, i+1,sum-arr[i],count); // Element is considered
        count = subsetSumTargetCount(arr,n,i+1,sum,count); //Element isn't considered
        return count;
    }
    static void subsetSumTargetPrint(int[] arr, int n, Vector<Integer> v, int sum) {
        if (sum == 0) {
            System.out.print("[");
            for (int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i)+ ", ");
            }
            System.out.print("]");
            System.out.println(); return;
        }
        if (n == 0) return;

        subsetSumTargetPrint(arr,n-1,v,sum); //Don't consider last element
        Vector<Integer> v1 = new Vector<Integer>(v);
        v1.add(arr[n-1]);
        subsetSumTargetPrint(arr,n-1,v1,sum - arr[n-1]); //Consider last element
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = scn.nextInt();

        int[] arr = new int[size];
        for (int i = 0 ; i < size; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scn.nextInt();

        int count = subsetSumTargetCount(arr,size,0,target,0);
        System.out.print("The number of subsets whose sum is "+target+" is: "+count);

        System.out.println("Printing subsets line-by-line:");
        Vector<Integer> v = new Vector<Integer>();
        subsetSumTargetPrint(arr, size, v, target);
    }
}
