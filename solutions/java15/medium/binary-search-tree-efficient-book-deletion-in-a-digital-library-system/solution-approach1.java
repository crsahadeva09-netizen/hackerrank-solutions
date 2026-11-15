// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-search-tree-efficient-book-deletion-in-a-digital-library-system/problem?isFullScreen=true
// Problem     Binary Search Tree - Efficient Book Deletion in a Digital Library System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:36 p.m.
// Technique   recursive-bst-node-deletion
// Time        O(h)
// Space       O(h)
// Insight     The algorithm maintains the binary search tree property by replacing a node having two children with its in-order successor, which is the minimum value in its right subtree.
// Interview   Before: "How do you remove a node with two children from a BST?" After: "You locate the in-order successor, copy its value to the target node, and recursively delete that successor node, resulting in O(h) time complexity where h is the tree height."
// Pitfalls    (1) Failing to handle the case where the node to be deleted is the root of the tree.  (2) Incorrectly updating the parent's child reference when the deleted node has only one child.  (3) Forgetting to re-assign the result of the recursive deleteNode call to the parent's left or right pointer.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BST{
    public Node insert(Node root, int val){
        
        if(root == null){
            return new Node(val);
        }
        
        if(val<root.data){
            root.left = insert(root.left, val);
        } else if(val>root.data){
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public Node findMin(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    
    public Node deleteNode(Node root, int val){
        
        if(root == null){
            return null;
        }
        
        if(val<root.data){
            root.left = deleteNode(root.left, val);
        }else if(val > root.data){
            root.right = deleteNode(root.right, val);
        }else{
            
            if(root.left == null){
                return root.right;
            }
            
            else if(root.right == null){
                return root.left;
            }
            
            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        
        return root;
        
    }
    
    public void inorder(Node root){
        if(root == null){
            return;
        }
        
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
            root = b.insert(root, sc.nextInt());
        }
        
        b.deleteNode(root, sc.nextInt());
        
        b.inorder(root);
    }
}




