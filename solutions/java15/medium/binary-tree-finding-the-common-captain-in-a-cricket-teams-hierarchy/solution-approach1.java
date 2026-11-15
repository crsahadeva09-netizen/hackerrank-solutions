// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-finding-the-common-captain-in-a-cricket-teams-hierarchy/problem?isFullScreen=true
// Problem     Binary Tree - Finding the Common Captain in a Cricket Team's Hierarchy
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 08:31 p.m.
// Technique   recursive-lca-binary-tree
// Time        O(N)
// Space       O(H)
// Insight     The algorithm recursively searches for target nodes, returning the current node if it matches a target or if both subtrees return non-null results, effectively identifying the lowest common ancestor.
// Interview   Before: "How do I find the common manager in this hierarchy?" After: "You can use a recursive LCA approach that traverses the tree in O(N) time and O(H) space, where H is the tree height, by bubbling up the target nodes to find their junction point."
// Pitfalls    (1) The implementation assumes both target nodes exist in the tree, as the LCA logic returns a non-null node if only one target is found.  (2) The level-order construction relies on the exact input format of 'null' strings, which will throw a NumberFormatException if the input contains unexpected tokens.
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
