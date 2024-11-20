SELECT SUM(price) AS revenue
FROM products p
JOIN order_details d
ON (d.prod_id = p.prod_id)
JOIN orders o
ON (d.order_id = o.order_id)
WHERE YEAR(order_date) = 2013
  AND MONTH(order_date) = 05;
