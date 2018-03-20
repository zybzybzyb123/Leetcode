class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        int[] vis = new int[256];
        int ans = 0;
        for(int i = 0; i < S.length(); i++){
            int pos = S.charAt(i);
            vis[pos]++;
        }
        for(int i = 0; i < J.length(); i++){
            int pos = J.charAt(i);
            ans += vis[pos];
        }
        return ans;
    }
}