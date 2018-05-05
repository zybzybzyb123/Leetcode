SELECT
e1.name as Employee
FROM
Employee e1, Employee e2
WHERE
e1.ManagerId = e2.Id
AND
e1.Salary > e2.Salary