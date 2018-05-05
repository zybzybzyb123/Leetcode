SELECT
Email
FROM
Person
Group By
Email
HAVING
count(Email) > 1