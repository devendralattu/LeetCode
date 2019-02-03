class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        
        int n = A.length;
        int total = 0;
        int result[] = new int[n];
        // add all even numbers
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                total += A[i];
            }
        }
        int row = queries.length;

        for (int i = 0; i < row; i++) {
            int qIndex = queries[i][1];
            int qValue = queries[i][0];
            int aValue = A[qIndex];

            if(aValue % 2 == 0) {
                if ((aValue + qValue) % 2 == 0) {
                    result[i] = total + qValue;
                } else {
                    result[i] = total - aValue;
                }
            } else {
                if ((aValue + qValue) % 2 == 0) {
                    result[i] = total + aValue + qValue;
                } else {
                    result[i] = total;
                }
            }
            A[qIndex] += qValue;
            total = result[i];
        }

        return result;
    }
}
