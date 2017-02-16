# Tutorial-3 : Interval Trees
Implementation of Interval trees in java.

### Input/Output Format
```
Format to insert Interval               : "1 lowValue highValue"
Format to delete Interval               : "2 lowValue highValue"
Format to search for Interval overlap   : "3 lowValue highValue"
Input to stop the execution             : "-1"
```

### Input/Output
```
// Inserting Nodes (intervals)
1 15 20
1 10 30
1 17 19
1 5 20
1 12 15
1 30 40
```

`// Searching for overlapping intervals`<br>
`3 14 16` generates output `An overlapping node found. {15,20}`<br>
`3 21 23` generates output `An overlapping node found. {10,30}`

