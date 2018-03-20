class Solution {
    int[] cnt = new int[26];
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0){
            return false;
        }
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            cnt[ch - 'A']++;
        }
        return (cnt['U' - 'A'] == cnt['D' - 'A']) &&
            (cnt['L' - 'A'] == cnt['R' - 'A']);
    }
}