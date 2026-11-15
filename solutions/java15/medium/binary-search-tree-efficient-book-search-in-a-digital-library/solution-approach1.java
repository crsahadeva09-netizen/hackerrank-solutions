// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-search-tree-efficient-book-search-in-a-digital-library/problem?isFullScreen=true
// Problem     Binary Search Tree - Efficient Book Search in a Digital Library
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:07 p.m.
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
