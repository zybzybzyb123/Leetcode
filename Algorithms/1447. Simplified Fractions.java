/**
 * 可以先打表 不过这个数据量直接算就行
 */

class Solution {
    private int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(String.format("%d/%d", j, i));
                }
            }
        }
        return ans;
    }
}