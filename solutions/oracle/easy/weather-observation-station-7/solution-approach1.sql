-- ──────────────────────────────────────────────────
-- Link        https://www.hackerrank.com/challenges/weather-observation-station-7/problem?isFullScreen=true
-- Problem     Weather Observation Station 7
-- Difficulty  Easy
-- Subdomain   Basic Select
-- Platform    HackerRank
-- Language    oracle
-- Status      Accepted
-- Submitted   2026-10-02, 05:17 p.m.
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

