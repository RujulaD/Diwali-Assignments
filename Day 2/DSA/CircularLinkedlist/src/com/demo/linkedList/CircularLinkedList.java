package com.demo.linkedList;

public class CircularLinkedList {
	Node head;

    // Inner class Node
    class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // (a) Insert new node at n-th position
    public void insertAtPosition(int pos, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            if (pos != 1) {
                System.out.println("List is empty. Adding at position 1.");
            }
            head = newNode;
            head.next = head;
            return;
        }

        // Insert at first position
        if (pos == 1) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            head = newNode;
            temp.next = head;
            return;
        }

        // Insert at middle or end
        Node temp = head;
        int count = 1;
        while (temp.next != head && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (count == pos - 1) {
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Position out of bounds. Node added at the end.");
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // (b) Delete node by data value
    public void deleteByData(int val) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        Node previous = null;

        // Case 1: Only one node in list
        if (head.data == val && head.next == head) {
            head = null;
            System.out.println("Node with data " + val + " deleted.");
            return;
        }

        // Case 2: Head node to delete
        if (head.data == val) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            System.out.println("Node with data " + val + " deleted.");
            return;
        }

        // Case 3: Other nodes
        do {
            previous = current;
            current = current.next;
            if (current.data == val) {
                previous.next = current.next;
                System.out.println("Node with data " + val + " deleted.");
                return;
            }
        } while (current != head);

        System.out.println("Node with data " + val + " not found.");
    }

    // (c) Modify node (ask user)
    public void modifyNode(int oldData, int newData) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                System.out.println("Node data modified successfully!");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node with given data not found!");
    }

    // (d) Display circular linked list
    public void displayData() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

}
