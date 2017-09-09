/*
    Count the number of prime numbers less than a non-negative number, n.
*/

public int countPrimes(int n) {

    boolean[] isNonPrime = new boolean[n];
    int count = 0;

    for(int i = 2; i < n; i++) {

        if(!isNonPrime[i]) {
            count++;

            for(int j = 2; i * j < n; j++) {
                isNonPrime[i * j] = true;
            }
        }

    }

    return count;
}
