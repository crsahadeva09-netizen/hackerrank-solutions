-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-9/problem?isFullScreen=true
-- Problem     Weather Observation Station 9
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:18 p.m.
-- Technique   regexp-negation-distinct
-- Time        O(N)
-- Space       O(N)
-- Insight     The query filters city names by excluding those starting with vowels using a case-insensitive regular expression and removes duplicates via the distinct keyword.
-- Interview   Before: "How do I filter strings starting with specific characters?" After: "Use the regexp_like function with a negated character class to exclude vowels. This approach runs in O(N) time, where N is the number of rows, and ensures unique results using distinct."
-- Pitfalls    (1) Failing to include both uppercase and lowercase vowels in the regular expression character class.  (2) Forgetting the distinct keyword, which results in duplicate city names being returned.  (3) Misinterpreting the requirement to exclude cities starting with vowels as excluding cities containing vowels anywhere.
-- ──────────────────────────────────────────────────



select distinct city from station
where not regexp_like(city, '^[aeiouAEIOU]');

