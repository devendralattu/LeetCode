/*
    987-123-4567
    123 456 7890
    (123) 456-7890

    Your script should output the following valid phone numbers:

    987-123-4567
    (123) 456-7890
*/

$ grep -e '\(^[0-9]\{3\}-[0-9]\{3\}-[0-9]\{4\}$\)' -e '\(^([0-9]\{3\})[ ][0-9]\{3\}-\([0-9]\{4\}\)$\)' file.txt
