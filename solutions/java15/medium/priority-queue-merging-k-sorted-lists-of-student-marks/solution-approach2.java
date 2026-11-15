// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/priority-queue-merging-k-sorted-lists-of-student-marks/problem?isFullScreen=true
// Problem     Priority Queue - Merging K Sorted Lists of Student Marks
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 01:36 a.m.
// Technique   priority-queue-min-heap
// Time        O(N log N)
// Space       O(N)
// Insight     The implementation uses a single min-heap to collect all elements from all lists, which implicitly sorts them upon extraction.
// Interview   Before: "I would merge these K lists using a pointer-based approach to maintain O(N log K) complexity." After: "This implementation uses a single PriorityQueue to store all N elements, resulting in O(N log N) time complexity, which is efficient enough given the constraints."
// Pitfalls    (1) The implementation adds all elements to a single heap, which ignores the pre-sorted property of the input lists and increases time complexity to O(N log N).  (2) The code assumes all input integers are valid and does not handle potential empty list inputs or null values.
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
