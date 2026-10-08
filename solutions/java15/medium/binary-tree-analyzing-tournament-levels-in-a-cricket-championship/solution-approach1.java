// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-analyzing-tournament-levels-in-a-cricket-championship/problem?isFullScreen=true
// Problem     Binary Tree - Analyzing Tournament Levels in a Cricket Championship
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-08, 11:41 a.m.
// Technique   level-order-queue-tree-construction
// Time        O(N)
// Space       O(N)
// Insight     The algorithm reconstructs the binary tree from a level-order array using a queue and then recursively calculates the maximum depth by returning one plus the maximum height of the left and right subtrees.
// Interview   Before: How would you calculate the maximum depth of a binary tree given its level-order representation? After: I would first reconstruct the tree using a queue to track parent nodes, then apply a recursive depth-first search. This approach runs in O(N) time and space, correctly handling null nodes as empty branches.
// Pitfalls    (1) The index i increments twice per loop iteration, which may cause an ArrayIndexOutOfBoundsException if the input array does not match the expected structure.  (2) The height function returns 0 for a null node, which correctly represents an empty tree but might be misinterpreted if the problem defines depth starting from 1 for a single node.  (3) The buildtree method assumes the input array is perfectly formatted for level-order traversal, failing if the number of nulls does not align with the binary tree structure.
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
    
    public int height(Node root){
        if(root == null)
            return 0;
            
        return 1 + Math.max(height(root.left),height(root.right));
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
      System.out.println(bt.height(root));
      
    }
}
