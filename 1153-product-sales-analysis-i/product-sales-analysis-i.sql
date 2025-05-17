# Write your MySQL query statement below
select product_name, year, price
from Sales as s
join Product p
on s.product_id = p.product_id;