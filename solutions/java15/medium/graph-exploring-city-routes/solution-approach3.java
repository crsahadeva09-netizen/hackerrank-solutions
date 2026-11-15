// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-exploring-city-routes/problem?isFullScreen=true
// Problem     Graph - Exploring City Routes
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 12:26 a.m.
// Technique   recursive-dfs-adjacency-list
// Time        O(V + E)
// Space       O(V + E)
// Insight     The algorithm maintains a visited array to track explored nodes and recursively traverses unvisited neighbors in an adjacency list representation of an undirected graph.
// Interview   Before: "How would you perform a depth-first traversal on an undirected graph?" After: "I would use an adjacency list to store the graph and a boolean array to track visited nodes, ensuring O(V + E) time complexity by visiting each node and edge exactly once."
// Pitfalls    (1) Failing to initialize the adjacency list with v+1 capacity leads to an IndexOutOfBoundsException when accessing nodes indexed from 1 to v.  (2) Forgetting to mark nodes as visited immediately upon printing causes infinite recursion in graphs containing cycles.  (3) Assuming the graph is directed when the problem implies undirected roads, which requires adding edges in both directions.
// ──────────────────────────────────────────────────

// import java.io.*;
// import java.util.*;

// public class Solution {
//     public static void DFS(int n, int[] visited, List<List<Integer>> arr ){
        
//         if(visited[n]==0){
//             System.out.print(n + " ");
//             // mark printed verted as visited
//             visited[n] = 1;
//         }
         
//         //  Recursion for the adjacent elements
//         for(int num:arr.get(n)){
//         // if adj vertex is not visited it is sent to Traversal else move forw
//             if(visited[num]==0){
//                 DFS(num, visited, arr);
//             }
//         }        
        
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         int v = sc.nextInt();
//         int e = sc.nextInt();
        
//         // Adjacent List Construction
        
//         List<List<Integer>> arr = new ArrayList<>();
        
//         for(int i=0; i<=v; i++){
//             arr.add(new ArrayList<>());
//         }
        
//         for(int i=0; i<e; i++){
//             int l = sc.nextInt();
//             int m = sc.nextInt();
            
//             arr.get(l).add(m);
//             arr.get(m).add(l);      // Since undirectional Graph
            
//         }
        
//         // starting vertex of Traversal
//         int start = sc.nextInt();

//         // Visited array to track if the vertex is visited
//         int[] visited = new int[v+1];
        
//         // DFS Traversal
//         DFS(start, visited, arr);
        
//     }
// }


import java.util.*;

public class Main{
    public static void DFS(int[] vis, ArrayList<ArrayList<Integer>> arr, int n){
        
        if(vis[n]==0){
            System.out.print(n + " ");
            vis[n] = 1;
        }
        
        for(int num:arr.get(n)){
            if(vis[num]==0){
                DFS(vis, arr, num);
            }
        }
        
        
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr.get(l).add(m);
            arr.get(m).add(l);
            
        }
        
        int[] vis = new int[v+1];
        
        DFS(vis, arr, sc.nextInt());
        
    }
}
















