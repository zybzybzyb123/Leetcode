class Solution {
    //每次可以改变一个字符,对应就是两个字符计数的变化
    private boolean isPalindrome(int[] cnt1, int[] cnt2, int k) {
        int cnt = 0;
        for (int i = 0; i < cnt1.length; i++) {
            if (((cnt2[i] - cnt1[i]) & 1) == 1) {
                cnt++;
            }
        }
        return cnt / 2 <= k;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        //统计出前缀和
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                int[] cnt = new int[26];
                cnt[ch - 'a']++;
                map.put(i, cnt);
            } else {
                int[] pre = map.get(i - 1);
                int[] cnt = Arrays.copyOf(pre, pre.length);
                cnt[ch - 'a']++;
                map.put(i, cnt);
            }
        }
        List<Boolean> ans = new ArrayList<>(queries.length);
        int[] empty = new int[26];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1], k = queries[i][2];
            //这里就可以优化下
            if (left == right) {
                ans.add(true);
            } else {
                ans.add(isPalindrome(map.getOrDefault(left - 1, empty), map.get(right), k));
            }
        }
        return ans;
    }
}