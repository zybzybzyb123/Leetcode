/**
 * 预处理words算出来一个频率数组
 */

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] cnt = new int[12];
        for (String word : words) {
            int val = getVal(word);
            cnt[val]++;
        }
        for (int i = 9; i > 0 ; i--) {
            cnt[i] += cnt[i + 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = getVal(queries[i]);
            ans[i] = cnt[val + 1];
        }
        return ans;
    }

    private int getVal(String word) {
        char[] array = word.toCharArray();
        Arrays.sort(array);
        int temp = 1;
        char ch = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == ch) {
                temp++;
            } else {
                break;
            }
        }
        return temp;
    }
}