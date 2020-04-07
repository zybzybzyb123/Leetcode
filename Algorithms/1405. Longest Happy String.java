/**
 * 假设a > 2 * (b +_c + 1), a会用不完
 * 先全部填充a, 之后用b和c替换,优先从2的位置替换,间隔替换
 */

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        char ch = 'a';
        if (c >= a && c >= b) {
            ch = 'c';
            c = Math.min(c, 2 * (a + b + 1));
        } else if (b >= a && b >= c) {
            ch = 'b';
            b = Math.min(b, 2 * (a + c + 1));
        } else {
            ch = 'a';
            a = Math.min(a, 2 * (b + c + 1));
        }
        int sum = a + b + c;
        int[] cnt = new int[]{a, b, c};
        char[] arrays = new char[sum];
        Arrays.fill(arrays, ch);
        for (int i = 2; i >= 0; i--) {
            updateValue(ch, cnt, arrays, i);
        }
        return new String(arrays);
    }

    private void updateValue(char ch, int[] cnt, char[] arrays, int begin) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cnt[i];
        }
        if (sum == 0) {
            return;
        }
        for (int i = begin; i < arrays.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                if (j != ch - 'a' && cnt[j] > 0) {
                    arrays[i] = (char) ('a' + j);
                    cnt[j]--;
                    break;
                }
            }
        }
    }
}