package Leetcode;

import java.util.*;

/**
 * Created by ZUOYANBIN1 on 2017/9/18.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(null == nums || 0 == nums.length){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //先添加空集
        result.add(new ArrayList<>());
        for(int num : nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.subsets(nums);
        for(List<Integer> list : ans){
            System.out.println(Arrays.toString(list.toArray()));
        }
//        System.out.println(solution);
    }
}
