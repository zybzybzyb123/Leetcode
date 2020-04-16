/**
 * 截取前缀和后缀放到set再判断就好了
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (i == 0 && j == n) {
                        continue;
                    }
                    set.add(word.substring(i, j));
                }
            }
        }
        for (String word : words) {
            if (set.contains(word)) {
                ans.add(word);
            }
        }
        return ans;
    }
}