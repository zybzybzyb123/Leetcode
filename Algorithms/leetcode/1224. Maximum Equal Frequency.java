/**
 * 119ms 无脑hashmap法
 */

class Solution {
    private boolean isValid(Map<Integer, Set<Integer>> map) {
        Set<Integer> keySet = map.keySet();
        if (keySet.size() == 2) {
            Iterator<Integer> iterator = keySet.iterator();
            int maxKey = iterator.next(), minKey = iterator.next();
            if (maxKey < minKey) {
                int temp = maxKey;
                maxKey = minKey;
                minKey = temp;
            }
            return (maxKey - minKey == 1 && map.get(maxKey).size() == 1) || (minKey == 1 && map.get(minKey).size() == 1);
        } else {
            int key = keySet.iterator().next();
            return key == 1 || map.get(key).size() == 1;
        }
    }
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100005];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = 0, kSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt[num]++;
            if (cnt[num] > 1) {
                Set<Integer> oldKeySet = map.get(cnt[num] - 1);
                if (oldKeySet.size() == 1) {
                    map.remove(cnt[num] - 1);
                    kSize--;
                } else {
                    oldKeySet.remove(num);
                }
            }
            if (map.containsKey(cnt[num])) {
                map.get(cnt[num]).add(num);
            } else {
                kSize++;
                map.put(cnt[num], new HashSet(Arrays.asList(num)));
            }
            if (kSize < 3 && isValid(map)) {
                ans = i + 1;
            }
        }
        return ans;
    }
}