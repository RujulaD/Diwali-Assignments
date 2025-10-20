package com.demo.test;

import java.util.Arrays;
import java.util.Scanner;
import com.demo.sort.QuickSortStrings;

public class testQuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] arr = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println("\nBefore Sorting:");
        System.out.println(Arrays.toString(arr));

        
        QuickSortStrings.sortStrings(arr);

        System.out.println("\nAfter Sorting (Alphabetically):");
        System.out.println(Arrays.toString(arr));
    }
}
