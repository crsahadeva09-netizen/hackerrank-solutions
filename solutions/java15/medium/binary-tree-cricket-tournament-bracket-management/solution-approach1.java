// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-cricket-tournament-bracket-management/problem?isFullScreen=true
// Problem     Binary Tree - Cricket Tournament Bracket Management
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-06, 10:52 p.m.
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
    public Node buildTree(int[] arr, int n){
        
        if(n==0 || n==-1){
            return null;
        }
        
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        int i=1;
        
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            
            if(i<n && arr[i] != -1){
                curr.left = new Node(arr[i]);
                q.offer(curr.left);
            }
            
            i++;
            
            if(i<n && arr[i] != -1){
                curr.right  =new Node(arr[i]);
                q.offer(curr.right);
            }
            
            i++;
        }
        
        return root;
    }
    
    public void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
        
    }
}

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        
        int[] nodes = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            nodes[i] = arr.get(i);
        }
        
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes, nodes.length);
        b.preorder(root);
        
    }
}








