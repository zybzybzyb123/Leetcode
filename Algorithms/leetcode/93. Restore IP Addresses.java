/**
 * 面试遇到这个题,感觉还有点意思,结果一搜就是原题
 * 当时理解的原题有点不一样,有几个边界有问题
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        getAllIps(s.toCharArray(), 0, s.length(), "", 4, ans);
        return ans;
    }
    public void getAllIps(char[] nums, int begin, int end, String cur, int cnt, List<String> ans) {
        //cnt < 0剪枝,不然会超时
        if (end - begin < cnt || cnt < 0) {
            return;
        }
        //必须用完
        if (cnt == 0 && begin == end) {
            //去掉头部的.
            ans.add(cur.substring(1));
            return;
        }
        //不能跳过这个数字
//        getAllIps(nums, begin + 1, end, cur, cnt, ans);
        int temp = 0;
        for (int i = begin; i < end; i++) {
            temp = temp * 10 + nums[i] - '0';
            if (temp >= 256) {
                break;
            }
            getAllIps(nums, i + 1, end, cur + "." + temp, cnt - 1, ans);
            if (temp == 0) {
                break;
            }
        }
    }
}