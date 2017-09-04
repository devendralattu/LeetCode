/*
    How would you print just the 10th line of a file?
    For example, assume that file.txt has the following content:
    Line 1
    Line 2
    Line 3
    Line 4
    Line 5
    Line 6
    Line 7
    Line 8
    Line 9
    Line 10
    Line 11
    Line 12
    Your script should output the tenth line, which is:
    Line 10
  
    if file has less than 10 lines then don't print anything
*/ 

$ head file.txt
/*
    Line 1
    Line 2
    Line 3
    Line 4
    Line 5
    Line 6
    Line 7
    Line 8
    Line 9
    Line 10
*/

$ head -1 file.txt
/*
    Line 1
*/

$ tail file3.txt
/*
    Line 4
    Line 5
    Line 6
    Line 7
    Line 8
    Line 9
    Line 10
    Line 11
    Line 12
*/

$ tail -n +10 file3.txt
/*
    Line 10
    Line 11
    Line 12
*/

$ tail -n +10 file3.txt | head -2
/*
    Line 10
    Line 11
*/

$ tail -n +10 file.txt | head -1
/*
    Line 10
*/
