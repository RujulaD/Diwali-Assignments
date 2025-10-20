package com.demo.test;

import java.util.Scanner;

import com.demo.queue.circularQueue;


public class testCircularQueue {

	public static void main(String[] args) {
		circularQueue ob = new circularQueue();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n--- Circular Queue Menu ---");
	            System.out.println("1. Enqueue (Insert)");
	            System.out.println("2. Dequeue (Delete)");
	            System.out.println("3. Peek (Front element)");
	            System.out.println("4. Display Queue");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter element to insert: ");
	                    int val = sc.nextInt();
	                    ob.enqueue(val);
	                    break;

	                case 2:
	                    ob.dequeue();
	                    break;

	                case 3:
	                    ob.peek();
	                    break;

	                case 4:
	                    ob.display();
	                    break;

	                case 5:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }
	    }
	

}
