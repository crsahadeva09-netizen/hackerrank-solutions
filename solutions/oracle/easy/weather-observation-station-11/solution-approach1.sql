-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-11/problem?isFullScreen=true
-- Problem     Weather Observation Station 11
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:22 p.m.
-- ──────────────────────────────────────────────────



select distinct city from station
where not REGEXP_like(city, '^[aeiouAEIOU]') 
    or not regexp_like(city, '[aeiouAEIOU]$');

