/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/    

public String convertToTitle(int n) {

    StringBuilder sb = new StringBuilder();
    while(n > 26) {
        int m = n % 26;
        if(m == 0) {
            sb.append('Z');     
            n--;
        } else {
            sb.append((char)('A' + m - 1));    
        }
        n = n / 26;
    }
    if(n != 0) {
        sb.append((char)('A' + n - 1));
    }

    return sb.reverse().toString();
}


/* Faster and efficient
return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
In order words
return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
*/
