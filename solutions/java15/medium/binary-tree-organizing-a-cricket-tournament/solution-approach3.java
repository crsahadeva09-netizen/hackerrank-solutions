// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-organizing-a-cricket-tournament/problem?isFullScreen=true
// Problem     Binary Tree - Organizing a Cricket Tournament
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 03:05 p.m.
// Technique   queue-based-level-order-insertion
// Time        O(n)
// Space       O(n)
// Insight     The implementation constructs a complete binary tree by using a queue to track parent nodes and assigning incoming array elements as left and right children sequentially.
// Interview   Before: "How would you build a tree from an array?" After: "I use a queue to maintain the insertion order, ensuring each node is filled left-to-right. This approach runs in O(n) time and space, correctly handling the level-order structure required for the tournament bracket."
// Pitfalls    (1) Failing to check if i < n before assigning the right child leads to an ArrayIndexOutOfBoundsException when the total number of nodes is odd.  (2) Assuming the input array represents a Binary Search Tree instead of a level-order insertion sequence.  (3) Neglecting to handle the case where n is zero, which would cause a NullPointerException when accessing arr[0].
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
    public Node buildBst(int[] arr, int n){
        
        Node root = new Node(arr[0]);
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i=1;
        
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            
            curr.left = new Node(arr[i++]);
            q.offer(curr.left);
            
            if(i<n){
                curr.right = new Node(arr[i++]);
                q.offer(curr.right);
            }
        }
        
        return root;
    }
    
    public void BFS(Node root){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            System.out.print(curr.data + " ");
            
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }        
        
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        BinaryTree bt = new BinaryTree();
        
        Node root = bt.buildBst(arr, arr.length);
        
        bt.BFS(root);
    }
}
























