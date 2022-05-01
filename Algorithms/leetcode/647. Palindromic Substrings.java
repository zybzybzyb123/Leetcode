//可以用manacher算法
class Solution {
    public List<Integer> posList = new ArrayList<>();
    public int countSubstrings(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        //所有1位的情况
        int ans = str.length;
        for(int i = 1; i < str.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            if(str[i] == str[i - 1]){
                ans++;
                list.add(i - 1);
            }
            for(Integer pos : posList){
                if(pos > 0 && str[pos - 1] == str[i]){
                    ans++;
                    list.add(pos - 1);
                }
            }
            posList = list;
        }
        return ans;
    }
}