class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int ans = 0, flag = 0;
        int[] cnt = new int[256];
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            int pos = array[i];
            cnt[pos]++;
            if(cnt[pos] % 2 == 0){
                ans += 2;
                flag--;
            } else{
                flag++;
            }
        }
        return flag > 0 ? ans + 1 : ans;
    }
}