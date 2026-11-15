// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-search-tree-finding-the-kth-smallest-book-id-in-a-digital-library/problem?isFullScreen=true
// Problem     Binary Search Tree - Finding the Kth Smallest Book ID in a Digital Library
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 09:30 p.m.
// Technique   in-order-traversal-list-storage
// Time        O(N)
// Space       O(N)
// Insight     The implementation performs a full in-order traversal to populate a list, allowing the Kth smallest element to be retrieved via direct index access.
// Interview   Before: "I would perform a recursive in-order traversal to collect all nodes into a sorted list." After: "Since the list is sorted, I access the element at index k-1 in O(1) time, resulting in O(N) total time and O(N) space complexity to store the tree nodes."
// Pitfalls    (1) Accessing index k-1 without verifying if k is within the bounds of the list size, which causes an IndexOutOfBoundsException.  (2) Assuming the input k is always valid, as the problem statement implies a need to handle cases where k is out of range.
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

class BinarySearchTree {

    public Node insert(Node root, int val) {

        // Empty position found
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        }
        else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        
        return root;

    }

    // Inorder traversal
    public void inorder(Node root, List<Integer> l) {

        if (root == null) {
            return;
        }

        inorder(root.left, l);
        l.add(root.data);
        inorder(root.right, l);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        BinarySearchTree b = new BinarySearchTree();
        
        Node root = null;
        
        for(int i=0; i<n; i++){
            root = b.insert(root, sc.nextInt());
        }
        
        List<Integer> l = new ArrayList<>();
        b.inorder(root, l);
        
        int k = sc.nextInt();
        System.out.println(l.get(k-1));
    }
}


















