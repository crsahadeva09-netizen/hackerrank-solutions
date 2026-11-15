// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-search-tree-efficient-book-search-in-a-digital-library/problem?isFullScreen=true
// Problem     Binary Search Tree - Efficient Book Search in a Digital Library
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:07 p.m.
// Technique   recursive-bst-search-inorder
// Time        O(N)
// Space       O(H)
// Insight     The algorithm performs a standard recursive search to locate the target node and subsequently executes an in-order traversal to output all nodes within the identified subtree.
// Interview   Before: "How would you find a book and list its related subtree?" After: "I implemented a recursive search that runs in O(H) time, where H is the tree height, followed by an O(N) in-order traversal of the subtree to display all related books."
// Pitfalls    (1) Failing to handle the case where the search target does not exist in the BST, which requires printing 'Book not found'.  (2) Incorrectly implementing the in-order traversal, which must visit the left child, then the current node, then the right child to maintain sorted order.  (3) Assuming the BST is balanced, which could lead to O(N) worst-case time complexity if the tree is skewed.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int val){
        data = val;
        left = right = null;
    }
}

class BST{
    public Node build(Node root, int val){
        if(root == null)
            return new Node(val);
        else if(val<root.data)
            root.left = build(root.left, val);
        else if(val>root.data)
            root.right = build(root.right, val);
            
        return root;
    }
    
    public void search(Node root, int val){
        if(root == null){
            System.out.println("Book not found");
            return;
        }
        if(val == root.data){
            System.out.println("Book found! Subtree rooted at " + root.data + ":");
            inorder(root);
            return;
        }else if(val < root.data){
            search(root.left, val);
            return;
        }else if(val > root.data){
            search(root.right, val);
            return;
        }
        
    }
    
    public void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        BST b = new BST();
        
        Node root = null;
        
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            root = b.build(root, val);
        }
        
        b.search(root, sc.nextInt());
        
    }
}
