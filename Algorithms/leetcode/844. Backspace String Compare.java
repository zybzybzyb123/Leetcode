/**
 * 记录下双指针法,用栈的解法比较常规就不写了
 */

class Solution {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipI = 0;
        int skipJ = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipI++;
                    i--;
                } else if (skipI > 0) {
                    skipI--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipJ++;
                    j--;
                } else if (skipJ > 0) {
                    skipJ--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 != j >= 0) {
                return false;
            }
            if (i < 0 || S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}