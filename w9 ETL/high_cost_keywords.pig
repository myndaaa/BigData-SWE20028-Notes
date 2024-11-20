-- Step A: Load the data file
data = LOAD '/dualcore/ad_data[12]' AS (
    campaign_id: chararray,
    date: chararray,
    time: chararray,
    keyword: chararray,
    display_site: chararray,
    placement: chararray,
    was_clicked: int,
    cpc: int
);

-- Step B: Filter records to include only those where 'was_clicked' is 1
clicked = FILTER data BY was_clicked == 1;

-- Step C: Group the filtered records by 'keyword'
grouped = GROUP clicked BY keyword;

-- Step D: Generate a new relation with 'keyword' and total cost (sum of cpc)
totals = FOREACH grouped GENERATE group AS keyword, SUM(clicked.cpc) AS cost;

-- Step E: Sort the new relation by cost in descending order
sorted = ORDER totals BY cost DESC;

-- Step F: Limit the results to the top five records
top_five = LIMIT sorted 5;

-- Display the result
DUMP top_five;
