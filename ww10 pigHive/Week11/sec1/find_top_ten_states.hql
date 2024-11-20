SELECT state, COUNT(state) as num 
  FROM customers 
  GROUP BY state 
  ORDER BY num DESC 
  LIMIT 10;
