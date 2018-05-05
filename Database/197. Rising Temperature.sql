SELECT
w1.Id
FROM
Weather w1, Weather w2
WHERE
# DATE_ADD(w2.RecordDate, INTERVAL 1 DAY) = w1.RecordDate
DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
AND
w1.Temperature > w2.Temperature