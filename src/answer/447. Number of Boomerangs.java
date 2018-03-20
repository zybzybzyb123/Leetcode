class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(null == points || points[0].length == 0){
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            cnt.clear();
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                int var = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                if(cnt.get(var) == null){
                    cnt.put(var, 1);
                } else{
                    cnt.put(var, cnt.get(var) + 1);
                }
            }
            for(int var : cnt.values()){
                ans += var * (var - 1);
            }
        }
        return ans;
    }
}