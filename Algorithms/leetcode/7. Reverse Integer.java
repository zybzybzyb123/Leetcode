/**
 *  难点就是判断倒置以后可能溢出
 */

class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean flag = x > 0 ? true : false;
        if(!flag) x = -x;
        int ans = 0;
        while(x > 0){
            if(ans > Integer.MAX_VALUE / 10) return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return flag ? ans : -ans;
    }
}