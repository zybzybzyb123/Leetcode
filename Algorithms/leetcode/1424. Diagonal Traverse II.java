/**
 * 模拟题, 对应的对角线是i + j
 * 最后遍历的时候倒序就好了
 */

class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int cnt = 0;
        int maxn = 2 * 100_000;
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            cnt += nums.get(i).size();
            List<Integer> temp = nums.get(i);
            for (int j = 0; j < temp.size(); j++) {
                List<Integer> list = listMap.getOrDefault(i + j, new ArrayList<>());
                list.add(temp.get(j));
                listMap.put(i + j, list);
            }
        }
        int[] ans = new int[cnt];
        int id = 0;
        for (int i = 0; i < maxn; i++) {
            if (listMap.containsKey(i)) {
                List<Integer> list = listMap.get(i);
                for (int j = list.size() - 1; j >= 0 ; j--) {
                    ans[id++] = list.get(j);
                }
            }
        }
        return ans;
    }
}