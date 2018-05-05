SELECT
Name as Customers
FROM
Customers
WHERE
id
NOT IN (
    SELECT
    CustomerId
    FROM
    Orders
)