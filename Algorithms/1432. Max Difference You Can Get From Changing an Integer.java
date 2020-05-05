/**
 * 数据量比较小就直接暴力替换了,判断下又没有前导零
 */

class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int maxVal = num, minVal = num;
        for (int i = 0; i < 9; i++) {
            String temp = s.replaceAll(String.valueOf(i), "9");
            maxVal = Math.max(maxVal, Integer.valueOf(temp));
        }
        for (int i = 1; i <= 9; i++) {
            String temp = s.replaceAll(String.valueOf(i), "0");
            if (temp.charAt(0) != '0') {
                minVal = Math.min(minVal, Integer.valueOf(temp));
            }
            temp = s.replaceAll(String.valueOf(i), "1");
            minVal = Math.min(minVal, Integer.valueOf(temp));
        }
        return maxVal - minVal;
    }
}