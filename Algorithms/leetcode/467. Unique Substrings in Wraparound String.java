class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) return 0;
        char[] str = p.toCharArray();
        int[] dp = new int[26];
        dp[str[0] - 'a'] = 1;
        int cnt = 1;
        for(int i = 1; i < str.length; i++){
            int last = str[i - 1]  - 'a';
            int cur = str[i]  - 'a';
            if(cur == (last + 1) % 26){
                cnt++;
            } else{
                cnt = 1;
            }
            dp[cur] = Math.max(cnt, dp[cur]);
        }
        return Arrays.stream(dp).sum();
    }
}