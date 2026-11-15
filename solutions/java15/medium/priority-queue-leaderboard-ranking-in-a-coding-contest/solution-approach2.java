// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/priority-queue-leaderboard-ranking-in-a-coding-contest/problem?isFullScreen=true
// Problem     Priority Queue - Leaderboard Ranking in a Coding Contest
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 01:33 a.m.
// Technique   max-priority-queue-polling
// Time        O(N log N)
// Space       O(N)
// Insight     The implementation utilizes a max-priority queue to store all scores, allowing the Kth largest element to be retrieved by performing K successive poll operations.
// Interview   Before: "How would you find the Kth largest score from a list of strings?" After: "I would parse the strings into integers and use a max-priority queue to extract the Kth largest value in O(N log N) time, ensuring correct numerical comparison rather than lexicographical sorting."
// Pitfalls    (1) Using lexicographical comparison instead of integer comparison for string-based scores.  (2) Failing to account for the requirement that duplicate scores are treated as distinct entities in the ranking.  (3) Assuming the input size N is small enough to avoid potential integer overflow if scores exceed the range of a 32-bit signed integer.
// ──────────────────────────────────────────────────

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<size; i++){
            pq.add(sc.nextInt());
        }
        
        int k = sc.nextInt();
        
        int res = 0;
        
        for(int i=0; i<k; i++){
            res = pq.poll();
        }
        
        System.out.println(res);
        
    }
}
