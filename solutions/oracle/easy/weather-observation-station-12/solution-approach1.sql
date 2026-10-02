-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-12/problem?isFullScreen=true
-- Problem     Weather Observation Station 12
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:25 p.m.
-- Technique   regex-pattern-filtering
-- Time        O(N * M)
-- Space       O(N * M)
-- Insight     The query filters unique city names by applying two negative regex lookups to ensure neither the first nor the last character belongs to the set of vowels.
-- Interview   Before: "How would you filter strings based on multiple character constraints?" After: "I used REGEXP_LIKE with anchors to exclude vowels at both boundaries. This approach runs in O(N * M) time, where N is the number of rows and M is the average string length, ensuring distinct results."
-- Pitfalls    (1) Failing to use the DISTINCT keyword results in duplicate city names, violating the problem requirement.  (2) Omitting case-insensitive vowel checks in the regex pattern leads to incorrect filtering of city names starting or ending with uppercase vowels.
-- ──────────────────────────────────────────────────



select distinct city
from station
where not regexp_like(city, '^[aeiouAEIOU]')
    and not regexp_like(city, '[aeiouAEIOU]$');

