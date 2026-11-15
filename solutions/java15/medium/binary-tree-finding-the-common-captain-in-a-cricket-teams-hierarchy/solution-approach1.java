// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-finding-the-common-captain-in-a-cricket-teams-hierarchy/problem?isFullScreen=true
// Problem     Binary Tree - Finding the Common Captain in a Cricket Team's Hierarchy
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 08:31 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BinaryTree{
    public Node buildTree(String[] arr, int n){
        
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
                curr.right = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        
        return root;
    }
    
    public Node LCA(Node root, int p, int q){
        
        if(root == null || root.data == p || root.data == q){
            return root;
        }
        
        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        
        return (left!=null) ? left : right;
    }
}

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        
        BinaryTree bt = new BinaryTree();
        
        Node root = bt.buildTree(arr, n);
        
        int p = sc.nextInt();
        int q = sc.nextInt();
        
        Node Lca = bt.LCA(root, p, q);
        
        System.out.println(Lca.data);
        
    }
}
