/**
 * dfs 用个26位整型就可以标记是否出现过重复字符
 * 因为是无顺序的,每次从i的下一位开始递归,可以避免判重
 */

class Solution {
    //映射为一个26位的数
    private int getBits(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            //本身有重复字符
            if (((1 << pos) & ans) > 0) {
                return -1;
            }
            ans |= (1 << pos);
        }
        return ans;
    }

    private int dfs(List<String> arr, int cnt, int cur) {
        int ans = 0;
        for (int i = cur; i < arr.size(); i++) {
            String str = arr.get(i);
            int bit = getBits(str);
            if (bit > 0 && ((cnt & bit) == 0)) {
                //从i + 1开始, 避免判重
                ans = Math.max(ans, dfs(arr, cnt | bit, i + 1) + str.length());
            }
        }
        return ans;
    }

    public int maxLength(List<String> arr) {
        return dfs(arr, 0, 0);
    }
}