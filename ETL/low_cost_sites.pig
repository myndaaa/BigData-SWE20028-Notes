-- Step A: Load the test data file
data = LOAD 'test_ad_data.txt' AS (
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

-- Step C: Group the filtered records by 'display_site'
grouped = GROUP clicked BY display_site;

-- Step D: Generate a new relation with 'display_site' and total cost (sum of cpc)
totals = FOREACH grouped GENERATE group AS display_site, SUM(clicked.cpc) AS cost;

-- Step E: Sort the new relation by cost in ascending order
sorted = ORDER totals BY cost;

-- Step F: Limit the results to the top three records
top_three = LIMIT sorted 3;

-- Display the result
DUMP top_three;
