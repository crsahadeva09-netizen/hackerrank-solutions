// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-identifying-cycles-in-urban-road-networks/problem?isFullScreen=true
// Problem     Graph - Identifying Cycles in Urban Road Networks
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 12:59 a.m.
// Technique   dfs-undirected-cycle-detection
// Time        O(V + E)
// Space       O(V + E)
// Insight     The algorithm detects a cycle in an undirected graph by performing a depth-first search and identifying any back-edge to a previously visited node that is not the immediate parent.
// Interview   Before: "How do you detect cycles in an undirected graph?" After: "I use DFS to track visited nodes and the parent pointer; if I encounter a visited neighbor that isn't the parent, a cycle exists. This runs in O(V + E) time and space, handling disconnected components by iterating through all vertices."
// Pitfalls    (1) Failing to pass the parent node in the recursive DFS call leads to incorrectly identifying the edge back to the parent as a cycle.  (2) Initializing the adjacency list with size v instead of v+1 causes an IndexOutOfBoundsException when accessing vertices indexed up to v.  (3) Neglecting to iterate through all vertices in the main loop prevents cycle detection in disconnected graph components.
// ──────────────────────────────────────────────────

import java.util.*;

public class Main{
    public static boolean DFS(int[] vis, ArrayList<ArrayList<Integer>> arr, int n, int parent){
        
        vis[n] = 1;
        
        for(int num:arr.get(n)){
            if(vis[num]==0){
                DFS(vis, arr, num, n);
            }else if(num!=parent){
                return true;
            }
        }
        
        return false;
        
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
        
        int[] vis = new int[v];
        
        boolean cy = false;
        
        for(int i=0; i<v; i++){
            if(vis[i] == 0){
                if(DFS(vis, arr, i, -1)){
                    cy = true;
                    break;
                }
            }
        }
        
        if(cy){
            System.out.println("Cycle Detected");
        }else{
            System.out.println("No Cycle Detected");
        }
        
    }
}
