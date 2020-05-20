package Leetcode;

import Leetcode.dataStructure.base.ListNode;
import Leetcode.dataStructure.base.TreeNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zero
 * @created 2020/04/29
 */

class Solution {

    public int numOfArrays(int n, int m, int k) {
        if (m < k) {
            return 0;
        }
        int mod = 1_000_000_007;
        long[][][] dp = new long[n + 1][m + 1][k + 2];
        for (int i = 1; i <= m; i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 1; l <= m; l++) {
                    for (int p = 1; p < l; p++) {
                        dp[i + 1][l][j + 1] = (dp[i + 1][l][j] + dp[i][p][j]) % mod;
                    }
                    dp[i + 1][l][j + 1] = (dp[i + 1][l][j] + l * dp[i][l][j + 1]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n][i][k]) % mod;
        }
        return (int) (ans);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public String nearestPalindromic(String n) {
        for (int i = 0, j = n.length() - 1; i < j; i++, j--) {
            if (n.charAt(i) != n.charAt(j)) {

            }
        }
        return null;
    }

    public int countTriplets(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int a = 0;
            for (int j = i - 1; j >= 0; j--) {
                a ^= arr[j];
                int b = 0;
                for (int k = i; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] parent = new int[n];
        int ans = 0;
        for (int[] edge : edges) {
            parent[edge[1]] = edge[0];
        }
        for (int i = hasApple.size() - 1; i > 0; i--) {
            if (hasApple.get(i)) {
                hasApple.set(i, false);
                ans += 2;
                if (parent[i] != 0) {
                    hasApple.set(parent[i], true);
                }
            }
        }
        return ans;
    }

    private int mod = 1_000_000_000 + 7;

    private int dfs(int n, int m, int k, int[][] sum, int[][][] dp) {
        if (dp[n][m][k] != -1) {
            return dp[n][m][k];
        }
        if (sum[n][m] < k) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int cnt = sum[n][m];
        dp[n][m][k] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum[i][m] < cnt) {
                dp[n][m][k] = (dp[n][m][k] + dfs(i, m, k - 1, sum, dp)) % mod;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (sum[n][i] < cnt) {
                dp[n][m][k] = (dp[n][m][k] + dfs(n, i, k - 1, sum, dp)) % mod;
            }
        }
        return dp[n][m][k];
    }

    public int ways(String[] pizza, int k) {
        int n = pizza.length, m = pizza[0].length();
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int flag = pizza[i].charAt(j) == 'A' ? 1 : 0;
                if (i == 0 && j == 0) {
                    sum[i][j] = flag;
                } else if (i == 0) {
                    sum[i][j] = sum[i][j - 1] + flag;
                } else if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + flag;
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + flag;
                }
            }
        }
        int[][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(n - 1, m - 1, k, sum, dp);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode pHead = new ListNode(-1), temp = head, newHead = pHead;
        pHead.next = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        ListNode p = head, q = head.next;
        for (int i = 1; i * k <= cnt; i++) {
            ListNode tail = p;
            for (int j = 0; j < k - 1; j++) {
                if (q != null) {
                    ListNode r = q.next;
                    q.next = p;
                    p = q;
                    q = r;
                }
            }
            pHead.next = p;
            pHead = tail;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        pHead.next = p;
        return newHead.next;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    public String arrangeWords(String text) {
        List<String> words =
                Arrays.stream(text.split(" "))
                        .map(String::toLowerCase)
                        .collect(Collectors.toList());
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            List<String> list = map.getOrDefault(word.length(), new ArrayList<>());
            list.add(word);
            map.put(word.length(), list);
        }
        int cnt = 0;
        boolean ok = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; cnt < words.size(); i++) {
            for (String word : map.getOrDefault(i, Collections.emptyList())) {
                if (!ok) {
                    ok = true;
                    char[] first = word.toCharArray();
                    first[0] = Character.toUpperCase(first[0]);
                    word = String.valueOf(first);
                } else {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(word);
                cnt++;
            }
        }

        return stringBuilder.toString();
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> list = favoriteCompanies.get(i);
            boolean res = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                boolean ok = true;
                if (i == j) {
                    continue;
                }
                Set<String> curSet = new HashSet<>(favoriteCompanies.get(j));
                for (int k = 0; k < list.size(); k++) {
                    if (!curSet.contains(list.get(k))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = false;
                    break;
                }
            }
            if (res) {
                ans.add(i);
            }
        }
        return ans;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
//        String filePath = "src/main/java/Leetcode/in.txt";
//        FileInputStream inputStream = new FileInputStream(filePath);
//        System.setIn(new BufferedInputStream(inputStream));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = reader.readLine();
        Solution solution = new Solution();
        String[] pizza = {".A..A", "A.A..", "A.AA.", "AAAA.", "A.AA."};
        int k = 5;
        System.out.println(solution.ways(pizza, k));
    }
}
