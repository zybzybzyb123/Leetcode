class Solution {
    private int cal(String str){
        int hb = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        int lb = (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');
        return hb * 60 + lb;
    }
    public int findMinDifference(List<String> timePoints) {
        int Max = -1, Min = 10000;
        int[] cnt = new int[1445];
        for(String point : timePoints){
            int num = cal(point);
            if(cnt[num] == 1) return 0;
            Max = num > Max ? num : Max;
            Min = num < Min ? num : Min;
            cnt[num]++;
        }
        int ans = Min + 1440 - Max, last = Max;
        for(int i = Max - 1; i >= Min; i--){
            if(cnt[i] == 1){
                ans = Math.min(ans, last - i);
                last = i;
            }
        }
        return ans;
    }
}