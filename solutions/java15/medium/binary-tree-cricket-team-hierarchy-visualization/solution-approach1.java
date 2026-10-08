// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/binary-tree-cricket-team-hierarchy-visualization/problem?isFullScreen=true
// Problem     Binary Tree - Cricket Team Hierarchy Visualization
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-08, 12:11 p.m.
// Technique   level-order-traversal-queue
// Time        O(N)
// Space       O(W)
// Insight     The algorithm performs a level-order traversal using a queue, capturing the last node processed at each depth level to represent the right-side view of the binary tree.
// Interview   Before: "How do you extract the rightmost nodes of a tree?" After: "I use a level-order traversal with a queue, where the last node of each level is printed. This approach runs in O(N) time and O(W) space, where W is the maximum width of the tree."
// Pitfalls    (1) The implementation assumes the input array is non-empty, which may cause a NullPointerException if the root is missing.  (2) The loop condition i < n in buildtree might fail if the input array length does not match the provided count n.  (3) The rightview method does not handle a null root input, leading to a NullPointerException on q.offer(root).
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
