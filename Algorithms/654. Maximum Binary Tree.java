import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

class Solution {
    public Integer getMax(Integer lMax, Integer rMax){
        if(lMax == null && rMax == null){
            return null;
        } else if(lMax == null){
            return rMax;
        } else if(rMax == null){
            return lMax;
        } else{
            return  Math.min(lMax, rMax);
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = null;
        TreeNode[] node = new TreeNode[nums.length];
        Map<Integer, Integer> lMap = new HashMap<>();
        Map<Integer, Integer> rMap = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            pos.put(nums[i], i);
            node[i] = new TreeNode(nums[i]);
            while(!stack.isEmpty()&&stack.peek()<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                lMap.put(i, null);
            } else{
                lMap.put(i, stack.peek());
            }
            stack.push(nums[i]);
        }
        stack.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty()&&stack.peek()<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rMap.put(i, null);
            } else{
                rMap.put(i, stack.peek());
            }
            Integer secMax = getMax(lMap.get(i), rMap.get(i));
            if(secMax == null){
                root = node[i];
            } else{
                Integer id = pos.get(secMax);
                if(id < i){
                    node[id].right = node[i];
                } else{
                    node[id].left = node[i];
                }
            }
            stack.push(nums[i]);
        }
        return root;
    }
}