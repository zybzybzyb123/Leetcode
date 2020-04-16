/**
 * 模拟法和数学规律法
 */
class Solution {
    // 模拟法
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Queue<Integer> pq = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int val : cnt) {
            if (val > 0) {
                pq.offer(val);
            }
        }
        int ans = 0;
        List<Integer> temp = new ArrayList<>(pq.size());
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size && i <= n; i++) {
                if (pq.peek() > 1) {
                    temp.add(pq.poll() - 1);
                } else {
                    pq.poll();
                }
                ans++;
            }
            if (!temp.isEmpty()) {
                if (n + 1 > size) {
                    ans += (n + 1) - size;
                }
                for (int val : temp) {
                    pq.offer(val);
                }
                temp = new ArrayList<>();
            }
        }
        return ans;
    }

    /**
     * 先假设字符组数不超过n+1(在时间间隔之内), 可以根据最大频数计算出一个时间
     * 之后把多余俄字符插入就好了, 下限是tasks的长度
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        int maxValue = cnt[25];
        int ans = (maxValue - 1) * (n + 1) + 1;
        for (int i = 0; i < 25; i++) {
            if (cnt[i] == maxValue) {
                ans++;
            }
        }
        return Math.max(ans, tasks.length);
    }
}