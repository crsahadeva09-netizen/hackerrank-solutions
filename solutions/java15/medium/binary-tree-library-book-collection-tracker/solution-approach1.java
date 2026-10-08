// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-library-book-collection-tracker/problem?isFullScreen=true
// Problem     Binary Tree - Library Book Collection Tracker
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-08, 11:11 a.m.
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
