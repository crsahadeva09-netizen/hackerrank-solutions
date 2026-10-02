-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-6/problem?isFullScreen=true
-- Problem     Weather Observation Station 6
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:16 p.m.
-- Technique   distinct-pattern-matching
-- Time        O(N)
-- Space       O(N)
-- Insight     The query filters unique city names by checking if the first character matches any vowel using case-insensitive pattern matching.
-- Interview   Before: "How do I filter strings starting with specific characters?" After: "Use the LIKE operator with wildcards combined with DISTINCT to ensure uniqueness. This approach runs in O(N) time, where N is the number of rows in the table, as it requires a full scan to evaluate the pattern for each city."
-- Pitfalls    (1) Failing to use DISTINCT results in duplicate city names, violating the problem requirement.  (2) Omitting the lower() function causes the query to miss cities starting with uppercase vowels.  (3) Using incorrect wildcard syntax in the LIKE clause prevents matching the start of the string.
-- ──────────────────────────────────────────────────



select distinct city
from station
where lower(city) like 'a%'
   or lower(city) like 'e%'
   or lower(city) like 'i%'
   or lower(city) like 'o%'
   or lower(city) like 'u%';

