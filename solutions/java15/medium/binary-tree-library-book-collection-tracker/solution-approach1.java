// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-library-book-collection-tracker/problem?isFullScreen=true
// Problem     Binary Tree - Library Book Collection Tracker
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-08, 11:11 a.m.
// Technique   level-order-queue-insertion
// Time        O(n)
// Space       O(n)
// Insight     The implementation uses a queue to perform level-order insertion of nodes into a binary tree, followed by a recursive post-order traversal to count the total number of nodes.
// Interview   Before: "How do you build a tree from an array and count nodes?" After: "I use a queue to maintain the insertion order for a complete binary tree structure, ensuring O(n) time complexity for both building the tree and counting nodes, even with n nodes."
// Pitfalls    (1) The queue-based insertion assumes a complete binary tree structure, which may not match arbitrary input sequences if a different tree topology is expected.  (2) The code fails if the input array is empty, as it attempts to access arr[0] without checking the array length.  (3) The recursive count method may trigger a StackOverflowError for extremely deep, skewed trees due to the O(n) recursion depth.
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
