/**
 * 就是简单找规律，注意只有一行的时候也是输出原始字符串
 */

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1) return s;
        char[] array = new char[s.length()];
        int id = 0, tot = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int dis =  (numRows - 1 - i) * 2;
            for (int j = i; j < array.length; j += tot) {
                array[id++] = s.charAt(j);
                //除了第一行和最后一行以外每次要多打印一个值
                if (dis > 0 && dis < tot && j + dis < array.length) {
                    array[id++] = s.charAt(j + dis);
                }
            }
        }
        return new String(array);
    }
}