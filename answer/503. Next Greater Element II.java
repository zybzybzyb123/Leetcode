/**
 * 关键就是把数组增长一倍，这样就解决数组的循环问题了
 * 使用一个单调栈(栈顶元素最小)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ans = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        int MaxPos = -1, len = 2 * nums.length;
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[stack.peek() % nums.length] < nums[i % nums.length]){
                ans[stack.pop() % nums.length] = nums[i % nums.length];
            }
            if(stack.isEmpty()){
                MaxPos = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(top >= nums.length){
                continue;
            }
            if(nums[top] == nums[MaxPos]){
                ans[top] = -1;
            } else{
                ans[top] = nums[MaxPos];
            }
        }
        return ans;
    }
}