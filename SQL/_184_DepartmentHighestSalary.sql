/*
    The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

    +----+-------+--------+--------------+
    | Id | Name  | Salary | DepartmentId |
    +----+-------+--------+--------------+
    | 1  | Joe   | 70000  | 1            |
    | 2  | Henry | 80000  | 2            |
    | 3  | Sam   | 60000  | 2            |
    | 4  | Max   | 90000  | 1            |
    +----+-------+--------+--------------+

    The Department table holds all departments of the company.

    +----+----------+
    | Id | Name     |
    +----+----------+
    | 1  | IT       |
    | 2  | Sales    |
    +----+----------+

    Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

    +------------+----------+--------+
    | Department | Employee | Salary |
    +------------+----------+--------+
    | IT         | Max      | 90000  |
    | Sales      | Henry    | 80000  |
    +------------+----------+--------+

*/
# Write your MySQL query statement below
SELECT d.Name as Department, e.Name as Employee, e.Salary as Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE (e.DepartmentId, e.Salary) IN 
                                    (SELECT e2.DepartmentId, MAX(e2.Salary) 
                                     FROM Employee e2 
                                     GROUP BY e2.DepartmentId
                                    );
                    
/* Similar but slower query */                    
# Write your MySQL query statement below
SELECT d.Name as Department, e.Name as Employee, e.Salary as Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE e.Salary IN (
					SELECT MAX(e2.Salary) 
					FROM Employee e2
                    WHERE e.DepartmentId = e2.DepartmentId
					GROUP BY e2.DepartmentId
				  );
