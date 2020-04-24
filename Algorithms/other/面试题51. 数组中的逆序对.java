/**
 * 复习了下树状数组
 * 0是特例要避免,重复出现的数也需要注意
 */

class Bit {
    private int[] c;
    public Bit(int n) {
        c = new int[n];
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void add(int x) {
        while (x < c.length) {
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

class Solution {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        Map<Integer, Integer> num2Pos = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            num2Pos.put(temp[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num2Pos.get(nums[i]) + 1;
        }
        Bit bit = new Bit(n + 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i - bit.sum(nums[i]);
            bit.add(nums[i]);
        }
        return ans;
    }
}