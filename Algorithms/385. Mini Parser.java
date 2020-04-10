/**
 * cur用全局变量比较好实现,不然需要递归方法带上当前的坐标
 */

class Solution {
    private int cur = 0;
    private NestedInteger getNestedIntegerList(char[] array) {

        NestedInteger nestedInteger = new NestedInteger();
        int flag = 1;
        int num = 0;
        while (cur < array.length - 1) {
            cur++;
            if (array[cur] == '[') {
                nestedInteger.add(getNestedIntegerList(array));
            } else if (array[cur] == ',') {
                continue;
            } else if (array[cur] == ']') {
                return nestedInteger;
            } else if (array[cur] == '-') {
                flag = -1;
            } else {
                num = num * 10 + array[cur] - '0';
                if (array[cur + 1] == ',' || array[cur + 1] == ']') {
                    nestedInteger.add(new NestedInteger(flag * num));
                    num = 0;
                    flag = 1;
                }
            }
        }
        return nestedInteger;
    }

    public NestedInteger deserialize(String s) {
        char[] array = s.toCharArray();
        cur = 0;
        if (array[0] != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        return getNestedIntegerList(array);
    }
}