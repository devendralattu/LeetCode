/*
    SQL query to output movies with an odd numbered ID and a description that is not 'boring'. 
    Order the result by rating.

    For example, table cinema:

    +---------+-----------+--------------+-----------+
    |   id    | movie     |  description |  rating   |
    +---------+-----------+--------------+-----------+
    |   1     | War       |   great 3D   |   8.9     |
    |   2     | Science   |   fiction    |   8.5     |
    |   3     | irish     |   boring     |   6.2     |
    |   4     | Ice song  |   Fantacy    |   8.6     |
    |   5     | House card|   Interesting|   9.1     |
    +---------+-----------+--------------+-----------+

    For the example above, the output should be:

    +---------+-----------+--------------+-----------+
    |   id    | movie     |  description |  rating   |
    +---------+-----------+--------------+-----------+
    |   5     | House card|   Interesting|   9.1     |
    |   1     | War       |   great 3D   |   8.9     |
    +---------+-----------+--------------+-----------+

*/
# Write your MySQL query statement below

SELECT *
FROM Cinema 
WHERE Id MOD 2 = 1 AND description NOT IN ('boring')
ORDER BY rating DESC;


/*
select *
from cinema
where mod(id, 2) = 1 and description != 'boring'
order by rating DESC;
*/

/*
SELECT * FROM cinema WHERE (id % 2 = 1) AND (description <> 'boring') ORDER BY rating DESC
*/
