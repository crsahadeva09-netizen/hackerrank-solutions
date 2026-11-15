// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/priority-queue-merging-k-sorted-lists-of-student-marks/problem?isFullScreen=true
// Problem     Priority Queue - Merging K Sorted Lists of Student Marks
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 01:36 a.m.
// ──────────────────────────────────────────────────

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int T = sc.nextInt();
        
        while(T--!=0){
            
            int size = sc.nextInt();
        
            for(int i=0; i<size; i++){
                pq.add(sc.nextInt());
            }
            
        }
        
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
                
    }
}
