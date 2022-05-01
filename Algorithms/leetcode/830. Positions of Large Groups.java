/**
 * 刷个水题，从左到右遍历就解决，注意最后一组
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if(S.length() < 3){
            return ans;
        }
        int left = 0, cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i) != S.charAt(i - 1)){
                if(cnt >= 3){
                    ans.add(Arrays.asList(left, left + cnt - 1));
                }
                left = i;
                cnt = 1;
            } else{
                cnt++;
            }
        }
        if(cnt >= 3){
            ans.add(Arrays.asList(left, left + cnt - 1));
        }
        return ans;
    }
}