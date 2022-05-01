/**
 * 关键是递归过程的坑
 */

class Solution {
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int getMidPos (int[] nums, int begin, int end) {
        int mid = begin + ((end - begin) >> 1);
        List<Integer> list = Arrays.asList(begin, end - 1, mid);
        list.sort((a, b) -> nums[a] - nums[b]);
        return list.get(1);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start >= end - 1) {
            return nums[start];
        }
        int midPos = getMidPos(nums, start, end);
        swap(nums, midPos, end - 1);
        int pivot = nums[end - 1];
        int left = start;
        for (int i = start; i < end - 1; i++) {
            if (nums[i] >= pivot)
                swap(nums, left++, i);
        }
        swap(nums, left, end - 1);
        if (left == k - 1) {
            return nums[left];
        } else if (left < k - 1) {
            return findKthLargest(nums, left + 1, end, k);
        } else {
            return findKthLargest(nums, start, left, k);
        }
    }

    //注意处理递归就没啥问题了
    private int findKthLargest(int[] nums, int begin, int end, int k) {
        if (begin == end - 1) {
            return nums[begin];
        }
        //挖洞填坑法
        int mid = nums[begin + ((end - begin) >> 1)];
        int pos = getMidPos(nums, begin, end);
        swap(nums, begin, pos);;
        int i = begin, j = end - 1, temp = nums[begin];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = temp;
        int curK = end - i - 1;
        if (curK == k - 1) {
            return temp;
        } else if (curK < k - 1) {
            return findKthLargest(nums, begin, i, k - curK - 1);
        } else {
            return findKthLargest(nums, i + 1, end, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length, k);
    }
}
