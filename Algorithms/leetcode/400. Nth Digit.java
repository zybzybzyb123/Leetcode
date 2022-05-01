class Solution {
    long[] num = new long[]{9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889, 8888888889L};
    public int findNthDigit(int n) {
        if(n < 9) return n;
        int pos = Arrays.binarySearch(num, n);
        if(pos >= 0) return 9;
        pos = -pos;
        long base = (long)Math.pow(10, pos - 1) - 1;
        long order = n - num[pos - 2];
        long ans = base + order / pos;
        long radix = order % pos;
        if(order % pos != 0){
            ans++;
        } else{
            radix = pos;
        }
        return (int)(ans / (int)Math.pow(10, pos - radix) % 10);
    }
}