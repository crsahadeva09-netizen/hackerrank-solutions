// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-organizing-a-cricket-tournament/problem?isFullScreen=true
// Problem     Binary Tree - Organizing a Cricket Tournament
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-09, 11:13 p.m.
// Technique   queue-based-level-order-insertion
// Time        O(n)
// Space       O(n)
// Insight     The implementation uses a queue to maintain the insertion order, ensuring that each node is filled left-to-right to construct a complete binary tree structure.
// Interview   Before: "How would you build a binary tree from an array?" After: "I use a queue to track parent nodes, ensuring each new element is assigned as the next available left or right child. This O(n) approach correctly builds the tree and performs a level-order traversal in O(n) time."
// Pitfalls    (1) Accessing arr[i] without checking i < arr.length inside the loop can cause an ArrayIndexOutOfBoundsException.  (2) Failing to handle the case where the input array is empty, as the code assumes arr[0] exists.  (3) Incorrectly assuming the tree is a Binary Search Tree, whereas this implementation strictly follows the registration order.
// ──────────────────────────────────────────────────

// import java.io.*;
// import java.util.*;

// class Node{
//     int data;
//     Node left;
//     Node right;
    
//     public Node(int data){
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }

// class BinaryTree{
    
//     public Node buildTree(int[] arr, int n){
        
//         Node root = new Node(arr[0]);
//         Queue<Node> q = new LinkedList<>();
        
//         q.offer(root);
//         int i=1;
        
//         while(!q.isEmpty() && i<n){
//             Node curr = q.poll();
            
//             curr.left = new Node(arr[i++]);
//             q.offer(curr.left);
            
//             if(i<n){
//                 curr.right  =new Node(arr[i++]);
//                 q.offer(curr.right);
//             }
//         }
        
//         return root;
//     }
    
//     public void bfs(Node root){
//         Queue<Node> q = new LinkedList<>();
        
//         q.offer(root);
        
//         while(!q.isEmpty()){
//             Node curr = q.poll();
//             System.out.print(curr.data + " ");
//             if(curr.left!=null)    
//                 q.offer(curr.left);
//             if(curr.right!=null)
//                 q.offer(curr.right);
//         }
//     }
// }

// public class Solution {
//     public static void main(String[] args) {
        
//         Scanner sc = new Scanner(System.in);
        
//         int n = sc.nextInt();
//         int[] arr = new int[n];
        
//         for(int i=0; i<n; i++){
//             arr[i] = sc.nextInt();
//         }
        
//         BinaryTree b = new BinaryTree();
//         Node root = b.buildTree(arr, n);
//         b.bfs(root);
        
//     }
// }







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
    public Node buildTree(int[] arr){
        Node root = new Node(arr[0]);
        
        Queue<Node> q = new LinkedList<>();
        int i = 1;
        q.offer(root);
        
        while(!q.isEmpty() && i<arr.length){
            Node temp = q.poll();
            
            temp.left = new Node(arr[i++]);
            q.offer(temp.left);
            if(i<arr.length){
                temp.right = new Node(arr[i++]);
                q.offer(temp.right);
            }
        }
        
        return root;
    }
    
    public void LOT(Node root){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null)
                q.offer(curr.left);
            if(curr.right != null)
                q.offer(curr.right);
        }
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        
        BinaryTree bt = new BinaryTree();
        
        Node root = bt.buildTree(arr);
        bt.LOT(root);
    }
}
