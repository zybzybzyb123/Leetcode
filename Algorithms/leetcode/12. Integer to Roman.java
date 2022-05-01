/**
 * 为什么赋值用new String[]会慢很多呢，有点神奇
 * 第一个是我自己写的解法，第二个是参考别人写的修改的
 * 第二种相对来说更优雅一点，处理4,9这种情况比较方便
 */
class Solution {
    private static final int LEN = 7;
    private static final String[] reman = {
            "I", "V", "X", "L", "C", "D", "M"
    };
    private static final int[] base = {1, 5, 10, 50, 100, 500, 1000};
    private int helper(int num, int id, StringBuilder sb) {
        int ans = 0;
        //System.out.format("num = %d, id = %d\n", num, id);
        if ((id & 1) == 1) {
            if ((num - base[id]) / base[id - 1] == 4) {
                sb.append(reman[id - 1]).append(reman[id + 1]);
                ans += 4 * base[id - 1] + base[id];
            } else {
                sb.append(reman[id]);
                ans += base[id];
            }
        } else {
            if (num / base[id] == 4) {
                sb.append(reman[id]).append(reman[id + 1]);
                ans += 4 * base[id];
            } else {
                int cnt = num / base[id];
                for (int i = 0; i < cnt; i++) {
                    sb.append(reman[id]);
                }
                ans += cnt * base[id];
            }
        }
        return ans;
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int id = LEN - 1;
        while (num > 0) {
            while (num < base[id]) {
                id--;
            }
            num -= helper(num, id, sb);
        }
        return sb.toString();
    }
}

class Solution {
    private static final String[] reman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final int[] base = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = reman.length - 1; i >= 0; i--) {
            while (num >= base[i]) {
                num -= base[i];
                sb.append(reman[i]);
            }
        }
        return sb.toString();
    }
}