/**
 * 注意下标从1开始
 */

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] array = sentence.split(" ");
        int ans = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith(searchWord)) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}