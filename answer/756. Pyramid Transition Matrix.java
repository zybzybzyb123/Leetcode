/**
 * 这个题目参考了一下标准解法, 标准解法比较巧妙的地方在于用6位保存
 * 允许的字符串关系(我是把字符串转换成int放进set里的),大体思路就是
 * 一个回溯法,不过这个存在连个回溯情况，一个是同一层，一个是不同层的.
 * 我参考了标准解法用一个整数标记一层(key,因为不超过6为数字,所以可以
 * 用底数为8表示每一层的字符串)，之后注意递归边界就ok了
 */
class Solution {
    boolean res = false;
    Set<Integer> set = new HashSet<>();
    Set<Integer> vis = new HashSet<>();
    private void build(int[][] nums, int len, int cur, int key){
        if(res) return;
        if(len == 1 && cur == 1){
            res = true;
            return;
        } else if(cur == len){
            //vis保存层的信息，出现过的情况直接返回
            if(vis.contains(key)) return;
            vis.add(key);
            //下一层
            build(nums, len - 1,0, 0);
        } else{
            int pre = nums[len][cur] * 26 * 26 + nums[len][cur + 1] * 26;
            for(int j = 0; j <= 6; j++){
                if(set.contains(pre + j)){
                    nums[len - 1][cur] = j;
                    //同层递归
                    build(nums, len, cur + 1, key * 8 + (j + 1));
                }
            }
        }
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if(allowed == null || allowed.size() == 0) return false;
        //set存放所有合法的字符串
        for(String word : allowed){
            int ans = 0;
            for (int i = 0; i < word.length(); i++) {
                ans = ans * 26 + word.charAt(i) - 'A';
            }
            set.add(ans);
        }
        int len = bottom.length();
        int[][] nums = new int[len][len];
        for (int i = 0; i < len; i++) {
            nums[len - 1][i] = bottom.charAt(i) - 'A';
        }
        //cur表示当前层的位置,key是当前层编码,len是层数
        build(nums, len - 1,0, 0);
        return res;
    }
}