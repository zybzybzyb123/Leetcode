class Solution {
    public String customSortString(String S, String T) {
        if(T == null) return null;
        if(S == null || S.length() == 0){
            return T;
        }
        int[] cnt = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T.length(); i++){
            int cur = T.charAt(i) - 'a';
            cnt[cur]++;
        }
        for(int i = 0; i < S.length(); i++){
            int cur = S.charAt(i) - 'a';
            while(cnt[cur] > 0) {
                sb.append((char) (cur + 'a'));
                cnt[cur]--;
            }
        }
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < cnt[i]; j++){
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}