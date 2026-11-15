// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-scoring-system-for-left-handed-players/problem?isFullScreen=true
// Problem     Binary Tree - Scoring System for Left-Handed Players
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 06:30 p.m.
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
    
    public int func(Node root){
        
        if(root == null)
            return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            if(curr.left!=null &&
                curr.left.left == null &&
                curr.left.right == null){
                
                sum += curr.left.data;
            }
            
            if(curr.left!=null){
                q.offer(curr.left);
            }
            
            if(curr.right != null){
                q.offer(curr.right);
            }
            
        }
        
        return sum;
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
      System.out.println(bt.func(root));
      
    }
}
