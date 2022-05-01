/**
 * 感觉不算啥好题
 * 很简单但是有点恶心那种
 * 分开保存字符和数字,注意多出来的字符的处理就好了
 */

class Solution {
    public String reformat(String s) {
        char[] array = s.toCharArray();
        int cnt = 0;
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        for (char ch : array) {
            if (ch >= '0' && ch <= '9') {
                cnt++;
                numList.add(ch);
            } else {
                charList.add(ch);
            }
        }
        if (Math.abs(2 * cnt - array.length) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = Math.min(cnt, array.length - cnt);
        for (int i = 0; i < n; i++) {
            sb.append(numList.get(i));
            sb.append(charList.get(i));
        }
        if (2 * cnt > array.length) {
            sb.append(numList.get(cnt - 1));
        } else if (2 * cnt < array.length) {
            sb.reverse().append(charList.get(cnt));
        }
        return sb.toString();
    }
}