/**
 * 我的思路暴力前两位数,判断整个数组是否满足条件
 * 代码待优化
 */


class Solution {
    private static final List<Integer> emptyList = Collections.emptyList();
    private List<Integer> getNumbers(int num) {
        if (num == 0) {
            return Arrays.asList(0);
        }
        List<Integer> ans = new ArrayList<>();
        while (num > 0) {
            ans.add(num % 10);
            num /= 10;
        }
        return ans;
    }
    private List<Integer> judge(int first, int second, char[] array, int begin) {
        if (first > Integer.MAX_VALUE - second) {
            return emptyList;
        }
        int end = array.length;
        List<Integer> ans = new ArrayList<>();
        ans.addAll(Arrays.asList(first, second));
        while (first <= Integer.MAX_VALUE - second && begin < end) {
            int third = first + second;
            List<Integer> nums = getNumbers(third);
            if (begin + nums.size() > end) {
                return emptyList;
            }
            for (int i = begin + nums.size() - 1; i >= begin ; i--) {
                if (array[i] - '0' != nums.get(begin + nums.size() - 1 - i)) {
                    return emptyList;
                }
            }
            begin = begin + nums.size();
            //
            ans.add(third);
            first = second;
            second = third;
        }
        return begin == end && ans.size() > 2 ? ans : emptyList;
    }
    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) {
            return emptyList;
        }
        List<Integer> ans = new ArrayList<>();
        int first = 0;
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num1 = array[i] - '0';
            if (first > Integer.MAX_VALUE / 10 || (first == Integer.MAX_VALUE / 10 && num1 > 0)) {
                break;
            }
            first = first * 10 + num1;
            int second = 0;
            for (int j = i + 1; j < array.length; j++) {
                int num2 = array[j] - '0';
                if (second >= Integer.MAX_VALUE / 10  || (second == Integer.MAX_VALUE / 10 && num2 > 0)) {
                    break;
                }
                second = second * 10 + num2;
                ans = judge(first, second, array, j + 1);
                if (ans.size() > 0) {
                    return ans;
                }
                if (second == 0) {
                    break;
                }
            }
            if (first == 0) {
                break;
            }
        }
        return ans;
    }
}