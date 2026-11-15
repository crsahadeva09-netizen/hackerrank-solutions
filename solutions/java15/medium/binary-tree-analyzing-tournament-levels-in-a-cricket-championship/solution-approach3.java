// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-analyzing-tournament-levels-in-a-cricket-championship/problem?isFullScreen=true
// Problem     Binary Tree - Analyzing Tournament Levels in a Cricket Championship
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 03:46 p.m.
// Technique   level-order-queue-tree-construction
// Time        O(N)
// Space       O(N)
// Insight     The algorithm constructs the binary tree using a queue for level-order traversal and then recursively calculates the maximum depth by adding one to the maximum depth of its subtrees.
// Interview   Before: "How would you calculate the height of a tree?" After: "I would use a recursive approach to find the maximum depth, which runs in O(N) time and space. The base case handles null nodes by returning 0, while internal nodes return 1 plus the maximum of their children's depths."
// Pitfalls    (1) The buildtree method assumes the input array is non-empty, which may cause a NullPointerException if the input size is zero.  (2) The level-order construction logic relies on the exact string "null" to identify missing nodes, failing if the input format uses different null representations.  (3) The recursion depth for a skewed tree could lead to a StackOverflowError for very large tournament structures.
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
        int i = 1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty() && i<n){
            Node curr = q.poll();

            if(!arr[i].equals("null")){
                curr.left = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if(i<n && !arr[i].equals("null")){
                curr.right = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }

            i++;
        }

        return root;
    }

    public int maxDepth(Node root){

        if(root==null){
            return 0;
        }

        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
        
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
