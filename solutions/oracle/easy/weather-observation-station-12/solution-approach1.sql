-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-12/problem?isFullScreen=true
-- Problem     Weather Observation Station 12
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:25 p.m.
-- ──────────────────────────────────────────────────



select distinct city
from station
where not regexp_like(city, '^[aeiouAEIOU]')
    and not regexp_like(city, '[aeiouAEIOU]$');

