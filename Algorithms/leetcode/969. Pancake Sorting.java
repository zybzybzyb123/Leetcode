/**
 * 这个题在算法竞赛入门经典第二版上见过
 * 翻转饼最多两次可以保证最大的饼出现在最后一位
 * 假设有十张饼，编号为10的在第7位，那么只需先翻转
 * 前7张(这时编号为10的出现在首位)，
 * 再整个翻转就可以保证编号为10的到达最底部
 * 其他同理，之后就排除最后的最大值进行翻转，
 * 可以保证最多2n次翻转完成
 */
class Solution {
    private void reverse(int k, int[] pos, int[] A) {
        for (int i = 0, j = k; i < j; i++, j--) {
            int temp = A[j];
            A[j] = A[i];
            A[i] = temp;
        }
        for (int i = 0; i <= k; i++) {
            pos[A[i]] = i;
        }
    }
    public List<Integer> pancakeSort(int[] A) {
        if (A.length == 1) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] pos = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            pos[A[i]] = i;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (pos[i + 1] == i) {
                continue;
            }
            ans.add(pos[i + 1] + 1);
            reverse(pos[i + 1], pos, A);
            ans.add(i + 1);
            reverse(i, pos, A);
        }
        //System.out.println(Arrays.toString(A));
        return ans;
    }
}