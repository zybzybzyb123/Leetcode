/**
 * 遍历就好了复杂度 O(kN)
 * 统计次数比较时候都出现过
 */

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length(), m = 1 << k;
        if (n + 1 - k < m) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int val = Integer.valueOf(s.substring(i, i + k), 2);
            if (set.add(val)) {
                cnt++;
            }
        }
        return cnt == m;
    }
}