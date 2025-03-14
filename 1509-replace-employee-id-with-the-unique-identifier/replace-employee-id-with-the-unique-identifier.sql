# Write your MySQL query statement below
select EmployeeUNI.unique_id , Employees.name
FROM EmployeeUNI 
Right join Employees
on EmployeeUNI.id = Employees.id;
