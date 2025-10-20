package com.demo.queue;

public class circularQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public circularQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue (Insert element)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
            rear.next = front; // circular link
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // maintain circular link
        }
        System.out.println("Inserted: " + data);
    }

    // Dequeue (Delete element)
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        int value;
        if (front == rear) { // only one element
            value = front.data;
            front = rear = null;
        } else {
            value = front.data;
            front = front.next;
            rear.next = front; // maintain circular link
        }

        System.out.println("Deleted: " + value);
    }

    // Peek (View front element)
    public void peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display all elements
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        Node temp = front;
        System.out.print("Circular Queue: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }
}
