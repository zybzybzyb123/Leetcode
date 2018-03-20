class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n <= 0) return 1;
        if(n > 10){
            n = 10;
        }
        int var = 9, fact = 9, sum = 0;
        for(int i = 1; i < n; i++){
            var *= fact--;
            sum += var;
        }
        return sum + 10;
    }
}