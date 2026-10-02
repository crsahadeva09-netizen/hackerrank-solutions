-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-9/problem?isFullScreen=true
-- Problem     Weather Observation Station 9
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:17 p.m.
-- Technique   regexp-like-negation
-- Time        O(N)
-- Space       O(N)
-- Insight     The query filters unique city names by applying a regular expression that matches strings starting with any character except the specified vowels.
-- Interview   Before: "How would you filter rows based on a character pattern?" After: "I use REGEXP_LIKE with a negated character class to exclude vowels at the start, ensuring O(N) time complexity and unique results via DISTINCT."
-- Pitfalls    (1) Failing to include both uppercase and lowercase vowels in the negated character class results in incomplete filtering.  (2) Omitting the DISTINCT keyword causes the output to include duplicate city names, violating the problem requirements.
-- ──────────────────────────────────────────────────



select distinct city from station
where regexp_like(city, '^[^aeiouAEIOU]');

