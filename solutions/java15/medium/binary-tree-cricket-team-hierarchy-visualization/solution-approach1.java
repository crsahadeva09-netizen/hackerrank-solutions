// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-cricket-team-hierarchy-visualization/problem?isFullScreen=true
// Problem     Binary Tree - Cricket Team Hierarchy Visualization
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-08, 12:11 p.m.
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
    
    public void rightview(Node root){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node last = null;
            for(int i=1; i<=size; i++){
                last = q.poll();
                if(last.left!=null)
                    q.offer(last.left);
                if(last.right!=null)
                    q.offer(last.right);
            }
            
            System.out.print(last.data + " ");
        }
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
      bt.rightview(root);
      
    }
}
