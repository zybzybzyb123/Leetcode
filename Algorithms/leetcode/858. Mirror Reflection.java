/**
 * 在纸上画图分析下就清楚了，我是把状态分为向上和向下了，
 * 每次反弹都从左边开始看(在右边就假设再多经过一次)
 * 详细见代码
 */

class Solution {
    public int mirrorReflection(int p, int q) {
        int h = p, x = 2 * q;
        boolean dir = true;
        for (;;) {
//            System.out.format("h : %d\n", h);
            //向上
            if (dir) {
                if ((h % x == 0)) {
                    return 2;
                }
                if (((h + q) % x == 0)) {
                    return 1;
                }
            } else {
                //向下
                if ((h + q) % x == 0) {
                    return 0;
                }
            }
            //两种情况一个是p + h % x一个是p - (2q - h % x)
            h = (p + h % x) % x;
            //方向变换
            dir = !dir;
        }
    }
}