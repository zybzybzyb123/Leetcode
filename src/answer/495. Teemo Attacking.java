class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int ans = 0, cur = -1, lastTime = 0;
        for(int time : timeSeries){
            if(cur < time){
                ans += duration;
            } else{
                ans += time - lastTime;
            }
            lastTime = time;
            cur = time + duration;
        }
        return ans;
    }
}