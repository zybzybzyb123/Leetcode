class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0]: o1[1] - o2[1];
            }
        });
        //模拟插入排序
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            if(ans[pos][0] != 0 || ans[pos][1] != 0){
                for(int j = i - 1; j >= pos; j--){
                    ans[j + 1][0] = ans[j][0];
                    ans[j + 1][1] = ans[j][1];
                }
            }
            ans[pos][0] = people[i][0];
            ans[pos][1] = people[i][1];
        }
        return ans;
    }
}
