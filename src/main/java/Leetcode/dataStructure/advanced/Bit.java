package Leetcode.dataStructure.advanced;

/**
 * 树状数组
 * @author zero
 * @created 2020/04/29
 */
public class Bit {
    private int[] c;
    private int sz;

    public Bit(int n) {
        c = new int[n + 1];
        sz = n;
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void add(int x) {
        while (x <= sz) {
            c[x]++;
            x += lowbit(x);
        }
    }

    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= lowbit(x);
        }
        return res;
    }
}