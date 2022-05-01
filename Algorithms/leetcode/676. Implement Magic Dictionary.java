/**
 * 这题没看到啥特别优雅的解法，大致就两种，
 * 其实思路几乎一样。都是保存字符串长度到
 * 集合的关系映射，一种保存时只保存当前串，
 * 查询的时候在比较是否有只差一个字符的。
 * 另一种就是保存时就保存所有可能对应的串，
 * 对单独每一位都进行替换(除了a-z的任何字
 * 符都行)，之后查找就直接判断就行了
 */

class MagicDictionary {

    /** Initialize your data structure here. */
    Map<Integer, ArrayList<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict){
            map.computeIfAbsent(word.length(), v -> new ArrayList<>()).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!map.containsKey(word.length())) return false;
        for(String temp : map.get(word.length())){
            int cnt = 0;
            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) != word.charAt(i)){
                    cnt++;
                }
                if(cnt > 1) break;
            }
            if(cnt == 1) return true;
        }
        return false;
    }
}