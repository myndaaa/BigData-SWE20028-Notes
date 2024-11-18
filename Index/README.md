 # Inverted Index
 
 First we cd to the respective directory and then
 extract the folder and put it to hdfs
 
```
[training@localhost ~]$ cd ~/training_materials/developer/data
[training@localhost data]$ ls
2022_access_log.gz      movielens.readme     nameyeartestdata
access_log.gz           movielens-small.sql  shakespeare
bible.tar.gz            movielens.sql        shakespeare-stream.tar.gz
invertedIndexInput.tgz  movie_metadata.csv   shakespeare.tar.gz
[training@localhost data]$ tar zxvf invertedIndexInput.tgz
invertedIndexInput/
invertedIndexInput/1kinghenryiv
invertedIndexInput/1kinghenryvi
invertedIndexInput/2kinghenryiv
invertedIndexInput/2kinghenryvi
invertedIndexInput/3kinghenryvi
invertedIndexInput/allswellthatendswell
invertedIndexInput/antonyandcleopatra
invertedIndexInput/asyoulikeit
invertedIndexInput/comedyoferrors
invertedIndexInput/coriolanus
invertedIndexInput/cymbeline
invertedIndexInput/glossary
invertedIndexInput/hamlet
invertedIndexInput/juliuscaesar
invertedIndexInput/kinghenryv
invertedIndexInput/kinghenryviii
invertedIndexInput/kingjohn
invertedIndexInput/kinglear
invertedIndexInput/kingrichardii
invertedIndexInput/kingrichardiii
invertedIndexInput/loverscomplaint
invertedIndexInput/loveslabourslost
invertedIndexInput/macbeth
invertedIndexInput/measureforemeasure
invertedIndexInput/merchantofvenice
invertedIndexInput/merrywivesofwindsor
invertedIndexInput/midsummersnightsdream
invertedIndexInput/muchadoaboutnothing
invertedIndexInput/othello
invertedIndexInput/periclesprinceoftyre
invertedIndexInput/rapeoflucrece
invertedIndexInput/romeoandjuliet
invertedIndexInput/sonnets
invertedIndexInput/tamingoftheshrew
invertedIndexInput/tempest
invertedIndexInput/timonofathens
invertedIndexInput/titusandronicus
invertedIndexInput/troilusandcressida
invertedIndexInput/twelfthnight
invertedIndexInput/twogentlemenofverona
invertedIndexInput/various
invertedIndexInput/venusandadonis
invertedIndexInput/winterstale
[training@localhost data]$ hadoop fs -put invertedIndexInput invertedIndexInput
[training@localhost data]$ hadoop fs -ls
Found 11 items
drwxr-xr-x   - training supergroup          0 2024-11-18 04:06 compressedsf
drwxr-xr-x   - training supergroup          0 2024-11-18 04:12 compressedsftotext
drwxr-xr-x   - training supergroup          0 2024-11-18 06:04 invertedIndexInput
drwxr-xr-x   - training supergroup          0 2024-11-16 07:10 outdir
drwxr-xr-x   - training supergroup          0 2024-11-16 20:58 output
drwxr-xr-x   - training supergroup          0 2024-11-01 02:18 shakespeare
drwxr-xr-x   - training supergroup          0 2024-11-01 02:17 testlog
drwxr-xr-x   - training supergroup          0 2024-11-18 03:49 uncompressedsf
drwxr-xr-x   - training supergroup          0 2024-11-15 23:26 wcdriver
drwxr-xr-x   - training supergroup          0 2024-11-01 02:15 weblog
drwxr-xr-x   - training supergroup          0 2024-11-15 21:41 wordlength
[training@localhost data]$ 

```


 See Output at --> http://localhost.localdomain:50075



