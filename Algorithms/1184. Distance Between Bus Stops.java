class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int[] sum = new int[distance.length + 1];
        sum[0] = distance[0];
        for (int i = 1; i < distance.length; i++) {
            sum[i] = sum[i - 1] + distance[i];
        }
        int begin = Math.min(start, destination), end = Math.max(start, destination);
        int ans = sum[end - 1] - sum[begin] + distance[begin];
        return Math.min(ans, sum[distance.length - 1] - ans);
    }
}