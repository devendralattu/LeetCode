/*
Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
                 return 964176192 (represented in binary as 00111001011110000010100101000000).
*/

// you need treat n as an unsigned value
public int reverseBits(int n) {

    int result = 0;
    int i = 0;
    while(i++ < 32) {
        result = (result << 1) | (n & 1);
        n = n >> 1;
    }

    return result;
}
