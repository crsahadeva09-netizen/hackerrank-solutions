-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-11/problem?isFullScreen=true
-- Problem     Weather Observation Station 11
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:22 p.m.
-- Technique   regexp-like-filtering
-- Time        O(N)
-- Space       O(N)
-- Insight     The query filters city names by applying a logical disjunction to two regular expression patterns that identify leading and trailing vowels respectively.
-- Interview   Before: "How would you filter strings based on multiple character position constraints?" After: "I used REGEXP_LIKE with OR logic to exclude cities starting or ending with vowels. This runs in O(N) time, where N is the number of rows, and ensures unique results via DISTINCT."
-- Pitfalls    (1) Failing to use DISTINCT results in duplicate city names which violates the problem requirement.  (2) Incorrectly using AND instead of OR logic fails to capture the requirement for cities that satisfy either condition.  (3) Omitting case sensitivity in the regular expression pattern misses cities starting or ending with uppercase vowels.
-- ──────────────────────────────────────────────────



select distinct city from station
where not REGEXP_like(city, '^[aeiouAEIOU]') 
    or not regexp_like(city, '[aeiouAEIOU]$');

