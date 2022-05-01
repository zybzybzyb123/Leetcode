/**
 * 用堆做的，还可以使用过二分法(从左下角开始)
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, ans = -1;
        int[] pos = new int[n];
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return matrix[o1][pos[o1]] - matrix[o2][pos[o2]];
        });
        for(int i = 0; i < n; i++){
            pq.offer(i);
        }
        while(k > 0){
            k--;
            int p = pq.poll();
            ans = matrix[p][pos[p]];
            if(pos[p] != matrix[p].length - 1){
                pos[p]++;
                pq.offer(p);
            }
        }
        return ans;
    }
}