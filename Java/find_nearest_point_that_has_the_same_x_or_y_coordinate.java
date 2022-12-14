class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        for (int[] p : points)
            if (p[0] == x || p[1] == y)
                min = Math.min(Math.abs(p[0] - x) + Math.abs(p[1] - y), min);

        for (int i = 0; i < points.length; i++)
            if ((points[i][0] == x || points[i][1] == y) &&
                    Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y) == min)
                return i;
        return -1;
    }
}
