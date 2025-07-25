# Write your MySQL query statement below
select distinct p.project_id, round(avg(e.experience_years),2) average_years
from Project as p
join Employee as e on p.employee_id = e.employee_id
group by p.project_id;