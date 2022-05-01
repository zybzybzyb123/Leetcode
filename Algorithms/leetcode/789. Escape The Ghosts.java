/**
 * 其实这个题就是一个简单难度的，就是计算到目标距离
 */
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int cur = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] ghost : ghosts){
            if(Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= cur) return false;
        }
        return true;
    }
}