/**
 * 判断图是不是联通图的水题
 * 无脑dfs给过了，只打败3%有点尴尬
 */
class Solution {
    private static final int LENGTH = 1005;
    int[] vis = new int[LENGTH];
    private void dfs(int i, List<List<Integer>> rooms) {
        vis[i] = 1;
        for (Integer key : rooms.get(i)) {
            if (vis[key] == 0) {
                dfs(key, rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1) {
            return true;
        }
        dfs(0, rooms);
        int cnt = Arrays.stream(vis).filter(i -> i > 0).sum();
        return cnt == rooms.size();
    }
}