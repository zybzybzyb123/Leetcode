/**
 * 牛顿迭代法 X(n+1) = ( X(n) +  N / X(n)) / 2;
 * 还可以用二分法解
 */
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long val, newVal = x;
        do{
            val = newVal;
            newVal = (val + x / val) / 2;
        } while(val > newVal);
        return (int)val;
    }
}