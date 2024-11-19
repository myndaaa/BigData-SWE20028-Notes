orders = LOAD '/dualcore/orders' AS (order_id:int, cust_id:int, order_dtm:chararray);
details = LOAD '/dualcore/order_details' AS (order_id:int, prod_id:int);

-- Filter orders within the target date range
recent = FILTER orders BY order_dtm matches '^2013-0[2345]-.*$';

-- Filter for the advertised product
tablets = FILTER details BY prod_id == 1274348;

-- Join the two datasets on order_id
joined = JOIN recent BY order_id, tablets BY order_id;

-- Extract the year and month
months = FOREACH joined GENERATE SUBSTRING(recent::order_dtm, 0, 7) AS month;

-- Group by month and count the records
grouped = GROUP months BY month;
counted = FOREACH grouped GENERATE group, COUNT(months.month) AS count;

-- Sort by month and display
sorted = ORDER counted BY group;
DUMP sorted;
