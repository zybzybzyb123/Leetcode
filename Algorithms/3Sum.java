class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> listSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 2; i--) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (map.getOrDefault(-(nums[i] + nums[j]), 0) > j) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j]));
                    if (!listSet.contains(temp)) {
                        ans.add(temp);
                        listSet.add(temp);
                    }
                }
            }
        }
        return ans;
    }
}