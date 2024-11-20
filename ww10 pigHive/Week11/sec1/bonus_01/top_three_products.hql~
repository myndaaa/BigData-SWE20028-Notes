-- NOTE: Since we use a GROUP BY clause, Hive requires
-- that we include all selected fields in that grouping.
-- If we don't, Hive throws an error with a message like:
--
--    SemanticException [Error 10025]: Expression 
--    not in GROUP BY key 'fieldname'
--

SELECT brand, name, COUNT(p.prod_id) AS sold 
FROM products p
JOIN order_details d
ON (p.prod_id = d.prod_id)
GROUP BY brand, name, p.prod_id
ORDER BY sold DESC
LIMIT 3;
