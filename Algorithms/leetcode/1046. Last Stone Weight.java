/**
 * 优先队列
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while (queue.size() >= 2) {
            int topA =  queue.poll(), topB = queue.poll();
            int val = Math.abs(topA - topB);
            if (val > 0) {
                queue.offer(val);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}