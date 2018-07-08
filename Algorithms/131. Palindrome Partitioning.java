/**
 * 搜索题，一个位置数组记录当前位置都有哪些位置(串尾)是回文串
 * 复用上一次记录的位置，只判断当前位置是否满足就行了
 * 然后就是无脑的暴力搜索
 */

class Solution {
    private void dfs(int cur, char[] array, List<List<Integer>> pos, List<String> list,
            List<List<String>> ans){
        if(cur == array.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        List<Integer> curList = pos.get(cur);
        for(int i = 0; i < curList.size(); i++){
            int next = curList.get(i) + 1;
            list.add(new String(array, cur, next - cur));
            dfs(next, array, pos, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<List<Integer>> pos = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            pos.add(list);
        }
        //需要倒过来迭代，每次复用上一次的结果，避免重复判断
        for(int i = array.length - 2; i >= 0; i--){
            List<Integer> nextList = pos.get(i + 1);
            if(array[i] == array[i + 1]){
                pos.get(i).add(i + 1);
            }
            for(int val : nextList){
                if(val <  array.length - 1 && array[i] == array[val + 1]){
                    pos.get(i).add(val + 1);
                }
            }
        }
        dfs(0, array, pos, new ArrayList<>(), ans);
        return ans;
    }
}