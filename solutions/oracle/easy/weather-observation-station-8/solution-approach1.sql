-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-8/problem?isFullScreen=true
-- Problem     Weather Observation Station 8
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:17 p.m.
-- ──────────────────────────────────────────────────



select distinct city from station
where regexp_like(city, '^[aeiouAEIOU]') and regexp_like(city, '[aeiouAEIOU]$');

