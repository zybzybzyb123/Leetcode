class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int Max = 0;
        for(List<Integer> list : wall){
            int sum = 0;
			//不计算右边界
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                Integer varCnt = cnt.get(sum);
                if(varCnt == null){
                    varCnt = 1;
                } else{
                    varCnt++;
                }
                cnt.put(sum, varCnt);
                Max = Math.max(varCnt, Max);
            }
        }
        return wall.size() - Max;
    }
}