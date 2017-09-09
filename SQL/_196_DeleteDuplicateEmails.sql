/*

    Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    | 3  | john@example.com |
    +----+------------------+
    Id is the primary key column for this table.

    For example, after running your query, the above Person table should have the following rows:

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    +----+------------------+

*/

#Method 1
DELETE p1
FROM Person p1 JOIN Person p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id;

#Method 2
DELETE p1 FROM Person p1
WHERE p1.Id NOT IN (
                    SELECT p2.Id 
                    FROM (
                            SELECT MIN(p3.Id) AS Id, p3.Email
                            FROM Person p3
                            GROUP BY p3.Email
                        ) p2
    
                )
