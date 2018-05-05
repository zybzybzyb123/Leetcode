class Solution{
	int MaxCnt = -1, cur = 0;
	Map<Integer, Integer> cnt = new HashMap<>();
	List<Integer> ans = new ArrayList<>();
	public void updateCnt(int val){
		Integer lastCnt = cnt.get(val);
		if(lastCnt == null){
			cnt.put(val, 1);
		} else{
			cnt.put(val, lastCnt + 1);
		}
		if(cnt.get(val) >= MaxCnt){
			if(cnt.get(val) > MaxCnt){
				MaxCnt = cnt.get(val);
				cur = 0;
			} else{
				cur++;
			}
			if(ans.size() > cur){
				ans.set(cur, val);
			} else{
				ans.add(val);
			}
		}
	}
	public int getSubtreeSum(TreeNode treeNode){
		int rootSum = treeNode.val;
		if(treeNode.left != null){
			int leftSum = getSubtreeSum(treeNode.left);
			rootSum += leftSum;
		}
		if(treeNode.right != null){
			int rightSum = getSubtreeSum(treeNode.right);
			rootSum += rightSum;
		}
		updateCnt(rootSum);
		return rootSum;
	}
	public int[] findFrequentTreeSum(TreeNode root) {
		if(null == root) return new int[0];
		getSubtreeSum(root);
		int[] res = new int[cur + 1];
		for(int i = 0; i < cur + 1; i++){
			res[i] = ans.get(i);
		}
	   return res;
	}
}
