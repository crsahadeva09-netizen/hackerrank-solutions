// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-search-tree-customer-age-based-filtering/problem?isFullScreen=true
// Problem     Binary Search Tree - Customer Age-Based Filtering
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 01:50 a.m.
// ──────────────────────────────────────────────────


import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    // Insert into BST
    public static Node insert(Node root, int val) {

        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);

        else if (val > root.data)
            root.right = insert(root.right, val);

        return root;
    }

    // Trim BST
    public static Node trimBST(Node root, int low, int high) {

        if (root == null)
            return null;

        // Current node is smaller than low
        if (root.data < low)
            return trimBST(root.right, low, high);

        // Current node is greater than high
        if (root.data > high)
            return trimBST(root.left, low, high);

        // Current node is within range
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        root = trimBST(root, low, high);

        preorder(root);

        sc.close();
    }
}
