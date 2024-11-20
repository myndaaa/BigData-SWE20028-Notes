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
