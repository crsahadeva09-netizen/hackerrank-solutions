// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-analyzing-tournament-levels-in-a-cricket-championship/problem?isFullScreen=true
// Problem     Binary Tree - Analyzing Tournament Levels in a Cricket Championship
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-09, 11:37 p.m.
// Technique   level-order-queue-construction-recursive-depth
// Time        O(N)
// Space       O(N)
// Insight     The algorithm reconstructs the binary tree from a level-order array using a queue and then computes the maximum depth by recursively finding the height of the subtrees.
// Interview   Before: "How would you calculate the maximum depth of a binary tree given its level-order representation?" After: "I build the tree using a queue to track parent nodes, then use a recursive O(N) depth-first search to find the longest path, handling null nodes as depth zero."
// Pitfalls    (1) The level-order construction assumes the input array follows the standard binary tree serialization where nulls are explicitly provided for missing children.  (2) The recursive maxDepth function will throw a NullPointerException if called on a null root, though the current implementation handles this with a base case check.  (3) The index i in the buildtree method must be carefully managed to ensure it does not exceed the array bounds when accessing children.
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
            
            if(!arr[i].equals("null")){
                curr.left = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            
            if(i<n && !arr[i].equals("null")){
                curr.right  =new Node(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        
        return root;
    }
    
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
      System.out.println(bt.maxDepth(root));
      
    }
}
