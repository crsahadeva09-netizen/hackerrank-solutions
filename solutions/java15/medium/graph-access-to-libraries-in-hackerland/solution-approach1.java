// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-access-to-libraries-in-hackerland/problem?isFullScreen=true
// Problem     Graph - Access to Libraries in HackerLand
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 12:39 a.m.
// Technique   dfs-connected-components
// Time        O(V + E)
// Space       O(V + E)
// Insight     The algorithm calculates the minimum cost by identifying connected components via DFS and choosing between building a library in every city or building one library per component with roads connecting the remaining cities.
// Interview   Before: "How do we minimize costs when libraries and roads have different prices?" After: "We use DFS to find connected components in O(V+E) time. If library costs are lower than road costs, we build libraries everywhere; otherwise, we build one library per component and connect the rest."
// Pitfalls    (1) Failing to handle the case where c_lib is less than c_road, which makes building roads suboptimal.  (2) Incorrectly initializing the adjacency list size to v instead of v+1, causing index out of bounds errors for 1-indexed cities.  (3) Forgetting to mark nodes as visited during DFS, leading to infinite recursion in cyclic graphs.
// ──────────────────────────────────────────────────

import java.util.*;

public class Main{
    public static int DFS(int[] vis, ArrayList<ArrayList<Integer>> arr, int n){
        
        if(vis[n]==0){
            // System.out.print(n + " ");
            vis[n] = 1;
        }
        int count = 1;
        
        for(int num:arr.get(n)){
            if(vis[num]==0){
                count += DFS(vis, arr, num);
            }
        }
        
        return count;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T--!=0){
            
            int v = sc.nextInt();
            int e = sc.nextInt();
            int c_lib = sc.nextInt();
            int c_road = sc.nextInt();
            
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
            
            if(c_lib<c_road){
                System.out.println(c_lib*v);
                continue;
            }
            
            int total_Cost = 0;
            
            for(int i=1; i<=v; i++){
                if(vis[i]==0){
                    int cnt = DFS(vis, arr, i);
                    total_Cost += c_lib+(cnt-1)*c_road;
                }
            }
            
            System.out.println(total_Cost);
            
        }
    }
}
