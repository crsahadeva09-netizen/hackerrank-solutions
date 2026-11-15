// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-cricket-tournament-bracket-management/problem?isFullScreen=true
// Problem     Binary Tree - Cricket Tournament Bracket Management
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 03:28 p.m.
// Technique   level-order-queue-tree-construction
// Time        O(N)
// Space       O(N)
// Insight     The implementation uses a queue to perform a level-order reconstruction of the binary tree from a flat array, where -1 values are treated as null children to maintain the structural integrity of the tournament bracket.
// Interview   Before: "How would you represent a tournament bracket as a tree?" After: "I use a level-order queue-based approach to build the tree in O(N) time and space, explicitly handling the -1 sentinel values to correctly identify null children in the bracket structure."
// Pitfalls    (1) Failing to increment the index i correctly when encountering -1, which causes the tree construction to misalign with the input array.  (2) Assuming the input array is perfectly balanced, ignoring that -1 values must be explicitly checked to prevent creating nodes with data -1.  (3) Incorrectly handling the queue poll operation when a node has no children, leading to premature termination of the tree construction.
// ──────────────────────────────────────────────────

// import java.io.*;
// import java.util.*;

// class Node{
//     int data;
//     Node left;
//     Node right;
    
//     public Node(int data){
//         this.data = data;
//         left = right = null;
//     }
// }

// class BinaryTree{
//     public Node buildTree(String[] arr, int n){
        
//         Node root = new Node(Integer.parseInt(arr[0]));
//         Queue<Node> q = new LinkedList<>();
        
//         q.offer(root);
//         int i=1;
        
//         while(!q.isEmpty() && i<n){
//             Node curr = q.poll();
            
//             curr.left = new Node(Integer.parseInt(arr[i++]));
//             q.offer(curr.left);
            
//             if(i<n){
//                 curr.right = new Node(Integer.parseInt(arr[i++]));
//                 q.offer(curr.right);
//             }
//         }
        
//         return root;
//     }
    
//     public void preorder(Node root){
//         if(root == null || root.data==-1){
//             return;
//         }
        
//         System.out.print(root.data + " ");
//         preorder(root.left);
//         preorder(root.right);
        
//     }
// }

// public class Solution {
//     public static void main(String[] args) {
        
//         Scanner sc = new Scanner(System.in);
//         String[] arr = sc.nextLine().split(" ");
        
//         BinaryTree bt = new BinaryTree();
        
//         Node root = bt.buildTree(arr, arr.length);
//         bt.preorder(root);
        
//     }
// }

// /* 
// public Node buildTree(int[] arr, int n){
        
//         Node root = new Node(arr[0]);
//         Queue<Node> q = new LinkedList<>();
        
//         q.offer(root);
        
        
//         return root;
//     } */


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
    // public Node buildtree(String[] arr, int n){
        
    //     Node root = new Node(Integer.parseInt(arr[0]));
    //     Queue<Node> q = new LinkedList<>();
        
    //     q.offer(root);
    //     int i=1;
        
    //     while(!q.isEmpty() && i<n){
    //         Node curr = q.poll();
            
    //         if(!arr[i].equals("null")){
    //             curr.left = new Node(Integer.parseInt(arr[i]));
    //             q.offer(curr.left);
    //         }
    //         i++;
            
    //         if(i<n && !arr[i].equals("null")){
    //             curr.right  =new Node(Integer.parseInt(arr[i]));
    //             q.offer(curr.right);
    //         }
    //         i++;
    //     }
        
    //     return root;
    // }
    
    public Node buildtree(String[] arr, int n){
        
        Node root = new Node(Integer.parseInt(arr[0]));
        int i = 1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            
            if(!arr[i].equals("-1")){
                curr.left = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            
            if(i<n && !arr[i].equals("-1")){
                curr.right = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            
            i++;
        }
        
        return root;
    }
    
    public void preorder(Node root){
        
        if(root==null){
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
      String[] arr = sc.nextLine().split(" ");
      
      Binarytree bt = new Binarytree();
      Node root =bt.buildtree(arr, arr.length);
      bt.preorder(root);
      
    }
}
