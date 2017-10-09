/*
	We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
	Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.

	Example:

	Input: 28
	Output: True
	Explanation: 28 = 1 + 2 + 4 + 7 + 14
*/


public boolean checkPerfectNumber(int num) {
		if(num <= 0) {
				return false;
		}    

		int sum = -num; // we will take the sum from -num to num
		int sqrt = (int) Math.sqrt(num);

		for(int i = 1; i <= sqrt; i++) {
				if(num % i == 0) {
						sum += i + (num / i);
						// '1' and 'num' get added in the first iteration. Thus the -num is compensated making sum = 0
				}
		}

		// sqrt is added twice if perfect square. Thus remove one sqrt value.
		if(sqrt * sqrt == num) {
				sum -= sqrt;
		}

		return sum == num;
}
