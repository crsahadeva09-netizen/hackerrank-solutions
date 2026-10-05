// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-organizing-a-cricket-tournament/problem?isFullScreen=true
// Problem     Binary Tree - Organizing a Cricket Tournament
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-05, 03:01 p.m.
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

class BinaryTree{
    
    public Node buildTree(int[] arr, int n){
        
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        int i=1;
        
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            
            curr.left = new Node(arr[i++]);
            q.offer(curr.left);
            
            if(i<n){
                curr.right  =new Node(arr[i++]);
                q.offer(curr.right);
            }
        }
        
        return root;
    }
    
    public void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left!=null)    
                q.offer(curr.left);
            if(curr.right!=null)
                q.offer(curr.right);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(arr, n);
        b.bfs(root);
        
    }
}
