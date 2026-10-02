-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-6/problem?isFullScreen=true
-- Problem     Weather Observation Station 6
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:16 p.m.
-- ──────────────────────────────────────────────────



select distinct city
from station
where lower(city) like 'a%'
   or lower(city) like 'e%'
   or lower(city) like 'i%'
   or lower(city) like 'o%'
   or lower(city) like 'u%';

