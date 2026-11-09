// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-tournament-ranking-system-in-cricket/problem?isFullScreen=true
// Problem     Binary Tree - Tournament Ranking System in Cricket
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-09, 11:16 p.m.
// Technique   level-order-queue-tree-construction
// Time        O(N)
// Space       O(N)
// Insight     The implementation uses a queue to reconstruct the binary tree from a level-order array representation, then performs a recursive inorder traversal to visit nodes in left-root-right order.
// Interview   Before: "How do I convert a level-order array into a tree?" After: "Use a queue to track parent nodes while iterating through the array, assigning children based on non-null values. This approach runs in O(N) time and O(N) space, correctly handling the null placeholders specified in the problem."
// Pitfalls    (1) Failing to increment the index i correctly when encountering a null value in the level-order array.  (2) Assuming the input array length always matches the number of nodes provided in the first line of input.  (3) Neglecting to check if the index i is within bounds before accessing the array for right child assignment.
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
    
    public void inorder(Node root){
        
        if(root==null){
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
      sc.nextLine();
      String[] arr = sc.nextLine().split(" ");
      
      Binarytree bt = new Binarytree();
      Node root =bt.buildtree(arr, arr.length);
      bt.inorder(root);
      
    }
}
