/**
 * 面试遇到了原题,最尴尬的是我看错题了,没注意可以是数字...
 * 回来一提交人都懵逼了,修改下也能通过
 */

class Solution {
    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            while (i < j && !isAlphaNumber(array, i)) {
                i++;
            }
            while (i < j && !isAlphaNumber(array, j)) {
                j--;
            }
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaNumber(char[] arr, int id) {
        char ch = arr[id];
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        if ((ch >= 'A' && ch <= 'Z')) {
            arr[id] = (char) (arr[id] + 32);
            return true;
        }
        return false;
    }
}