-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-7/problem?isFullScreen=true
-- Problem     Weather Observation Station 7
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:17 p.m.
-- Technique   regexp-like-pattern-matching
-- Time        O(N)
-- Space       O(N)
-- Insight     The query utilizes a regular expression to identify city names ending with any vowel character while ensuring uniqueness through the distinct keyword.
-- Interview   Before: "How would you filter strings ending in specific characters?" After: "I used regexp_like with the anchor '$' to match vowels at the end of the string, achieving O(N) time complexity while handling duplicates with distinct."
-- Pitfalls    (1) Failing to include the distinct keyword results in duplicate city names in the output.  (2) Omitting the anchor character '$' in the regular expression matches vowels anywhere in the city name instead of only at the end.
-- ──────────────────────────────────────────────────



-- select distinct city
-- from station
-- where lower(city) like '%a'
--     or lower(city) like '%e'
--     or lower(city) like '%i'
--     or lower(city) like '%o'
--     or lower(city) like '%u';

select distinct city
from station
where regexp_like(city, '[aeiouAEIOU]$');

