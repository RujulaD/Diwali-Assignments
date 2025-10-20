package com.demo.test;

import java.util.Scanner;
import com.demo.tree.BinarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice;
        do {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Add Node");
            System.out.println("2. Remove Node");
            System.out.println("3. Display InOrder");
            System.out.println("4. Display PreOrder");
            System.out.println("5. Display PostOrder");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int val = sc.nextInt();
                    bst.addNode(val);
                    break;
                case 2:
                    System.out.print("Enter value to remove: ");
                    int delVal = sc.nextInt();
                    bst.removeNode(delVal);
                    break;
                case 3:
                    bst.displayInOrder();
                    break;
                case 4:
                    bst.displayPreOrder();
                    break;
                case 5:
                    bst.displayPostOrder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
