    public int[][] kClosest(int[][] points, int K) {
        
        Arrays.sort(points, (int[] a, int[] b) ->
                (int)(Math.pow(a[0], 2) + Math.pow(a[1], 2) -
                Math.pow(b[0], 2) - Math.pow(b[1], 2)));
        return Arrays.copyOfRange(points, 0, K);
    }
