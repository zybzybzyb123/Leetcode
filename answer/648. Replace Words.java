/**
 * 用的hash表给解决了,之前用的sentence replaceAll方法
 * 解决不了a aa的问题
 * 其实这个题很适合用字典树，之后补充上
 */
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        Set<String> set = new HashSet<>(dict);
        //vis记录已经判断过的字符串
        Map<String, String> vis = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            if(vis.containsKey(word)) {
                sb.append(vis.get(word) + " ");
                continue;
            }
            String temp = word;
            boolean flag = false;
            //判断前缀是否在dict出现过
            for(int i = 1; i < word.length(); i++){
                temp = word.substring(0, i);
                if(set.contains(temp)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                sb.append(temp + " ");
                vis.put(word, temp);
            } else{
                sb.append(word + " ");
                vis.put(word, word);
            }
        }
        //滤掉末尾的空格
        return sb.substring(0, sb.length() - 1);
    }
}