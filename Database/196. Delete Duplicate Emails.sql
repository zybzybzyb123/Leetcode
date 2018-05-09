#mysql的in不能直接和聚合函数连用,需要
#在中间加一个临时表
DELETE
FROM
Person
WHERE
id
NOT IN(
	SELECT
	p.id
	FROM(
		SELECT
		Min(id) as id
		FROM
		Person
		GROUP BY
		Email
		#不要加having count(email) > 1,否则会删掉出现一次的email
	) p
)

#Solution的简单解法
DELETE
p1
FROM
Person p1, Person p2
WHERE
p1.Email = p2.Email
AND
p1.Id > p2.Id