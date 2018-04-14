/**
 * 递归获取每个子字符串进行操作，可以用一个哈希表
 * 保存已经出现过的字符串进行加速
 */
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for(int val1 : list1){
                    for(int val2 : list2){
                        switch (ch){
                            case '+' : res.add(val1 + val2);
                                break;
                            case '-' : res.add(val1 - val2);
                                break;
                            case '*' : res.add(val1 * val2);
                                break;
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}