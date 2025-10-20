package com.demo.test;

import java.util.Scanner;

public class testReverseNumber {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter an integer: ");
	        int n = sc.nextInt();
	        
	        int reversed = reverseNumber(n);
	        System.out.println("Reversed number: " + reversed);
	    }

	    public static int reverseNumber(int n) {
	        int reversed = 0;

	        while (n != 0) {
	            int digit = n % 10;         // Get last digit
	            reversed = reversed * 10 + digit;  // Append digit
	            n = n / 10;                 // Remove last digit
	        }

	        return reversed;
	    }

}
