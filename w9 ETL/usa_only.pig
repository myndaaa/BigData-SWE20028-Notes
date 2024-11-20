data = LOAD 'sample1.txt' AS (
    keyword:chararray, 
    campaign_id:chararray, 
    date:chararray, 
    time:chararray, 
    display_site:chararray, 
    was_clicked:int, 
    cpc:int, 
    country:chararray, 
    placement:chararray
);

usa_only = FILTER data BY country == 'USA';

reordered = FOREACH usa_only GENERATE campaign_id, 
               date,
               time,
               UPPER(TRIM(keyword)),
               display_site,
               placement,
               was_clicked,
               cpc;

DUMP reordered;
