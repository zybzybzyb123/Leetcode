/**
 * 排序一位一位比较就好了
 */

class Solution {
    private boolean judge(char[] array1, char[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < array2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return judge(array1, array2) || judge(array2, array1);
    }
}