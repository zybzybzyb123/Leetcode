/**
 * 思路就是遍历,必须满足各字符的计数关系后出现的大于等于前面的
 * 有一个k就全部-1,中途最大的cnt数就是青蛙数
 */

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 不是5的倍数直接返回
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        char[] array = {'c', 'r', 'o', 'a', 'k'};
        int[] cnt = new int[5];
        int ans = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            int pos = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == ch) {
                    pos = i;
                    for (int j = 0; j < i; j++) {
                        // 后面出现的字符数比前面大不合法
                        if (cnt[j] < cnt[i] + 1) {
                            return -1;
                        }
                    }
                }
            }
            if (pos < 0) {
                return -1;
            }
            if (pos == array.length - 1) {
                for (int i = 0; i < pos; i++) {
                    cnt[i]--;
                }
            } else {
                cnt[pos]++;
            }
            ans = Math.max(ans, cnt[pos]);
        }
        // 最后还必须所有字符相等才行
        for (int i = 0; i < cnt.length - 1; i++) {
            if (cnt[i] != cnt[i + 1]) {
                return -1;
            }
        }
        return ans;
    }
}