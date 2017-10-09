/*
	Given a positive integer, check whether it has alternating bits: 
	namely, if two adjacent bits will always have different values.

	Example 1:

	Input: 5
	Output: True
	Explanation:
	The binary representation of 5 is: 101

	Example 2:

	Input: 7
	Output: False
	Explanation:
	The binary representation of 7 is: 111.
*/


public class _693_BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {

		System.out.println(hasAlternatingBits(5));
		System.out.println(hasAlternatingBits_2(5));
	}

	public static boolean hasAlternatingBits(int n) {
		if (n <= 0) {
			return false;
		}
		int xor = n ^ (n >> 1);
		return (xor & (xor + 1)) == 0;
	}

	public static boolean hasAlternatingBits_2(int n) {
		if (n <= 0) {
			return false;
		}
		int i = (n & 1);
		while (n != 0) {
			if ((i & 1) == (n & 1)) {
				n = n >> 1;
				i++;
				continue;
			}
			return false;
		}
		return true;
	}
}
