// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-organizing-a-cricket-tournament/problem?isFullScreen=true
// Problem     Binary Tree - Organizing a Cricket Tournament
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-05, 03:01 p.m.
// Technique   queue-based-level-order-insertion
// Time        O(n)
// Space       O(n)
// Insight     The implementation uses a queue to maintain the insertion order, ensuring that each node is filled with left and right children sequentially to form a complete binary tree structure.
// Interview   Before: "How do I build a tree from an array?" After: "Use a queue to track parent nodes, inserting elements as children until the array is exhausted. This approach runs in O(n) time and space, effectively mapping the array indices to a level-order tree structure."
// Pitfalls    (1) Failing to check if the index i is less than n before assigning the right child, which causes an ArrayIndexOutOfBoundsException.  (2) Assuming the input array represents a binary search tree rather than a level-order insertion sequence.
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
