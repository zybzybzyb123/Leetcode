/**
 * 参考了讨论区的解法，自己实现了一下
 * 从高位开始处理,base是个左1右0的数
 * 最右边的1表示当前正在判断的位
 * 因为异或满足c = a ^ b 则 b = a ^ c
 * 所以可以通过set进行处理
 *
 * 另外这个题目很适合用字典树进行处理,最后针对每个数遍历
 * 树就可以获得他的异或值
 */

class Solution {
    public int findMaximumXOR(int[] nums) {
        //ans是足最大值, base取数的前（32 - i）位
        int ans = 0, base = 0;
        for (int i = 31; i >= 0 ; i--) {
            Set<Integer> set = new HashSet<>();
            base = base | (1 << i);
            //set保存数的前32 - i位值
            for(int num : nums){
                set.add(num & base);
            }
            //temp假设异或结果存在当前位
            int temp = ans | (1 << i);
            for(int num : set){
                //的确存在当前位，更新异或最大值
                if(set.contains(num ^ temp)){
                    ans = temp;
                    break;
                }
            }
        }
        return ans;
    }
}