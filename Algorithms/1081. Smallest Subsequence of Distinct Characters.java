/**
 * 最开始以为可以通过判断下一个字符来确定是否更新字符位置,
 * 如果是ab的话就在下一个a出现时删除第一个a,把最新的a加入
 * 后来发现局部最优解不一定是全局最优解,那个方法就放弃了
 * 参考了讨论区的思路就是一个单调栈的变形,需要考虑字符出现次数
 * 和是否出现过
 *
 */

class Solution {

    /**
     * error解法,维护一个双向链表的错误思路
     * @param text
     * @return
     */
    public String smallestSubsequence1(String text) {
        int[] pre = new int[30], next = new int[30];
        Arrays.fill(pre, -1);
        Arrays.fill(next, -1);
        int cur = 0, head = 0;
        //1 - 26
        for (char ch : text.toCharArray()) {
            int pos = ch - 96;
            if (pre[pos] == -1) {
                next[pos] = next[cur];
                next[cur] = pos;
                pre[pos] = cur;
                cur = pos;
            } else {
                if (next[pos] >= pos || next[pos] == -1) {
                    continue;
                } else {
                    int p = pre[pos], n = next[pos];
                    next[p] = n;
                    pre[n] = p;
                    next[pos] = next[cur];
                    next[cur] = pos;
                    pre[pos] = cur;
                    cur = pos;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (next[head] != -1) {
            int node = next[head];
            ans.append((char) (node + 96));
            head = node;
        }
        return ans.toString();
    }

    /**
     * 单调栈正确解法
     * @param text
     * @return
     */
    public String smallestSubsequence(String text) {
        LinkedList<Integer> stack = new LinkedList<>();
        char[] array = text.toCharArray();
        int[] cnt = new int[26];
        for (char ch : array) {
            cnt[ch - 'a']++;
        }
        boolean[] vis = new boolean[26];
        for (char ch : array) {
            int pos = ch - 'a';
            cnt[pos]--;
            if (vis[pos]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > pos && cnt[stack.peek()] > 0) {
                vis[stack.pop()] = false;
            }
            stack.push(pos);
            vis[pos] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append((char) (stack.pop() + 'a'));
        }
        return ans.reverse().toString();
    }
}