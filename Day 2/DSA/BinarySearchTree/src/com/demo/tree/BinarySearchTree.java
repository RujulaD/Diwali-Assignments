package com.demo.tree;

public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    
    public void addNode(int data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    
    public void removeNode(int data) {
        root = deleteRec(root, data);
    }

    private BSTNode deleteRec(BSTNode root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            
            root.data = minValue(root.right);

            
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(BSTNode root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    
    public void displayInOrder() {
        System.out.print("Inorder: ");
        inOrder(root);
        System.out.println();
    }

    public void displayPreOrder() {
        System.out.print("Preorder: ");
        preOrder(root);
        System.out.println();
    }

    public void displayPostOrder() {
        System.out.print("Postorder: ");
        postOrder(root);
        System.out.println();
    }

    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    private void preOrder(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
