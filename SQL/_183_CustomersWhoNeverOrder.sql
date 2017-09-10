/*
    Suppose that a website contains two tables, the Customers table and the Orders table. 
    Write a SQL query to find all customers who never order anything.

    Table: Customers.

    +----+-------+
    | Id | Name  |
    +----+-------+
    | 1  | Joe   |
    | 2  | Henry |
    | 3  | Sam   |
    | 4  | Max   |
    +----+-------+

    Table: Orders.

    +----+------------+
    | Id | CustomerId |
    +----+------------+
    | 1  | 3          |
    | 2  | 1          |
    +----+------------+

    Using the above tables as example, return the following:

    +-----------+
    | Customers |
    +-----------+
    | Henry     |
    | Max       |
    +-----------+

*/

# Method 1
SELECT c.Name as Customers
FROM Customers c
WHERE c.Id NOT IN ( SELECT o.CustomerId FROM Orders o);

# Method 2
SELECT c.Name AS Customers
FROM Customers c LEFT JOIN Orders o 
ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL
