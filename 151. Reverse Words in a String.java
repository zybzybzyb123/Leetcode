/**
 * 先来一个调用api的解法
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}