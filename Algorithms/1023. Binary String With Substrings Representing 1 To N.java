/**
 * 个人解法就是把小于N的字符串保存下来，最后比较
 * 集合是否等于N
 * 不过看了讨论区，发现其实可以用字典树优化一下空间
 */

class Solution {
    private boolean noMore(char[] a, char[] b) {
        if (a.length != b.length) {
            return a.length < b.length;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return true;
    }

    public boolean queryString(String S, int N) {
        char[] array = S.toCharArray();
        Set<String> set = new HashSet<>(N);
        char[] binaryArray = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0') {
                continue;
            }
            for (int j = i + 1; j <= array.length; j++) {
                if (j - i > binaryArray.length) {
                    break;
                }
                char[] temp = Arrays.copyOfRange(array, i, j);
//                    System.out.format("temp = %s, binary = %s\n", new String(temp), new String(binaryArray));
                if (noMore(temp, binaryArray)) {
                    set.add(new String(temp));
                }
            }
        }
        return set.size() == N;
    }
}