class Solution {
    // O(nk)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j >  0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    //翻转len - k, k和整体
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = (nums.length - 1 -  k) / 2; i >= 0; i--) {
            int temp = nums[nums.length - 1 - k  - i];
            nums[nums.length - 1 - k - i] = nums[i] ;
            nums[i] = temp;
        }
        for (int i = (k - 1) / 2; i >= 0; i--) {
            int temp = nums[nums.length - k + i];
            nums[nums.length - k + i] = nums[nums.length - 1 - i] ;
            nums[nums.length - 1 - i] = temp;
        }

        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i] ;
            nums[nums.length - 1 - i] = temp;
        }
    }

    //原地旋转
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int cnt = 0, len = nums.length;
        for (int i = 0; i < k; i++) {
            if (cnt >= len) break;
            int temp = nums[i], index = i;
            do {
                index = (index + k) % len;
                int temp1 = nums[index];
                nums[index] = temp;
                temp = temp1;
                cnt++;
            }  while (index != i);
        }
    }
}