package com.demo.test;

import java.util.Scanner;

import com.demo.linkedList.CircularLinkedList;

public class testCircularLinkedList {

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert new node at n-th position");
            System.out.println("2. Delete node by data");
            System.out.println("3. Modify node data");
            System.out.println("4. Display list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int val = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(pos, val);
                    break;

                case 2:
                    System.out.print("Enter data to delete: ");
                    int delVal = sc.nextInt();
                    list.deleteByData(delVal);
                    break;

                case 3:
                    System.out.print("Enter old data: ");
                    int oldData = sc.nextInt();
                    System.out.print("Enter new data: ");
                    int newData = sc.nextInt();
                    list.modifyNode(oldData, newData);
                    break;

                case 4:
                    list.displayData();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

	}


