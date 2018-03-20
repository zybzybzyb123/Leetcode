class Solution {
    public int integerBreak(int n) {
        if(n < 4){
            return n - 1;
        }
        int m = n / 3;
        int ans = 0;
        if(n % 3 == 1){
	        //4不拆
            ans = (int)Math.pow(3, m - 1) * 4;
        } else if(n % 3 == 2){
	        //5拆成3 * 2
            ans = (int)Math.pow(3, m) * 2;
        } else{
            ans = (int)Math.pow(3, m);
        }
        return ans;
    }
}