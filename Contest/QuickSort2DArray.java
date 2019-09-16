public class QuickSort2DArray {
    public static void main(String args[])
    {
        int[][] arr =
                    {{ 5, 12, 17, 21, 23 },
                    { 1,  2,  4,  6,  8 },
                    { 12, 14, 18, 19, 27 },
                    { 3,  7,  9, 15, 25 }};
        System.out.println("original array");
        printArray(arr);

        int m = arr.length, n = arr[0].length;
        sort(arr, 0, (m * n) - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    private static void sort(int[][] arr, int left, int right)
    {
        if (left >= right) {
            return;
        }
        int n = arr[0].length;
        int mid = left + (right - left) / 2;
        int pivot = arr[mid / n][mid % n];
        int index = partition(arr, left, right, pivot);
        sort(arr, left, index - 1);
        sort(arr, index, right);
    }

    private static int partition(int[][] arr, int left, int right, int pivot)
    {
        int n = arr[0].length;
        while (left <= right) {
            while (arr[left / n][left % n] < pivot) {
                left++;
            }
            while (arr[right / n][right % n] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left / n, left % n, right / n, right % n);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[][] arr, int row1, int col1, int row2, int col2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

    private static void printArray(int[][] arr) {
        String str = "|\t";
        for(int[] rows : arr){
            for(int col : rows){
                str += col + "\t";
            }
            System.out.println(str + "|");
            str = "|\t";
        }
        System.out.println();
    }
}

/*
original array
|	5	12	17	21	23	|
|	1	2	4	6	8	|
|	12	14	18	19	27	|
|	3	7	9	15	25	|

sorted array
|	1	2	3	4	5	|
|	6	7	8	9	12	|
|	12	14	15	17	18	|
|	19	21	23	25	27	|
*/
