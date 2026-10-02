-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-8/problem?isFullScreen=true
-- Problem     Weather Observation Station 8
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:17 p.m.
-- Technique   regexp-like-filtering
-- Time        O(N * M)
-- Space       O(N)
-- Insight     The query filters distinct city names by enforcing that both the first and last characters match the specified vowel set using regular expression patterns.
-- Interview   Before: "How do I filter strings based on multiple character constraints?" After: "Use REGEXP_LIKE with anchors to validate start and end characters. This approach runs in O(N * M) time, where N is the number of rows and M is the average string length, ensuring distinct results."
-- Pitfalls    (1) Failing to include both uppercase and lowercase vowels in the regular expression character class.  (2) Omitting the DISTINCT keyword, which results in duplicate city names being returned.  (3) Misplacing the anchors, where ^ must precede the first character and $ must follow the last character.
-- ──────────────────────────────────────────────────



select distinct city from station
where regexp_like(city, '^[aeiouAEIOU]') and regexp_like(city, '[aeiouAEIOU]$');

