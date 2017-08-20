# Write a SQL query to get the second highest salary from the Employee table.
# return null if there is no second highest salary

-- mtd 1
SELECT MAX(e.salary) as SecondHighestSalary
FROM employee e
WHERE e.salary < (
                    SELECT MAX(e2.salary) 
                    FROM employee e2
                );
              
              
-- mtd 2   
SELECT (
        SELECT DISTINCT e.Salary
        FROM Employee e
        ORDER BY e.Salary DESC
        LIMIT 1 OFFSET 1          -- LIMIT 1,1
        ) 
AS SecondHighestSalary;
