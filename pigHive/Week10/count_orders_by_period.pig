data = LOAD '/dualcore/orders' AS (order_id:int, cust_id:int, order_dtm:chararray);

-- Include only records within the target date range
recent = FILTER data BY order_dtm matches '^2013-0[2345]-\\d{2}\\s.*$';

-- Extract the year and month
months = FOREACH recent GENERATE SUBSTRING(order_dtm, 0, 7) AS month;

-- Group by month and count the orders
grouped = GROUP months BY month;
counted = FOREACH grouped GENERATE group, COUNT(months.month) AS count;

-- Sort by month and display
sorted = ORDER counted BY group;
DUMP sorted;
