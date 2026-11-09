// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-library-book-collection-tracker/problem?isFullScreen=true
// Problem     Binary Tree - Library Book Collection Tracker
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-09, 11:34 p.m.
// Technique   level-order-queue-insertion
// Time        O(n)
// Space       O(n)
// Insight     The implementation uses a queue to perform level-order insertion of nodes into a binary tree, followed by a recursive traversal to count the total number of nodes.
// Interview   Before: "How would you build a binary tree from an array and count its nodes?" After: "I use a queue to maintain the insertion order for a complete binary tree structure, ensuring O(n) time and space complexity to process all n nodes."
// Pitfalls    (1) The queue-based insertion assumes a level-order filling pattern which may not match arbitrary tree construction requirements.  (2) The code fails if the input array is empty because it accesses arr[0] without checking the array length.  (3) The recursive count method may cause a StackOverflowError for extremely deep, skewed trees.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Binarytree{
    public Node buildtree(String[] arr, int n){
        
        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        int i=1;
        
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            
            curr.left = new Node(Integer.parseInt(arr[i++]));
            q.offer(curr.left);
            
            if(i<n){
                curr.right  =new Node(Integer.parseInt(arr[i++]));
                q.offer(curr.right);
            }
        }
        
        return root;
    }
    
    public int count(Node root){
        if(root == null)
            return 0;
            
        return 1 + count(root.left) + count(root.right);
    }
}

public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();
      String[] arr = sc.nextLine().split(" ");
      
      Binarytree bt = new Binarytree();
      Node root =bt.buildtree(arr, arr.length);
      System.out.println(bt.count(root));
      
    }
}
