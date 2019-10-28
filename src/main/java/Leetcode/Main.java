package Leetcode;

import Leetcode.dataStructure.advanced.Trie;
import Leetcode.dataStructure.base.CustomFunction;
import Leetcode.dataStructure.base.ListNode;
import Leetcode.dataStructure.base.Node;
import Leetcode.dataStructure.base.TreeNode;

import javax.print.DocFlavor;
import javax.print.StreamPrintService;
import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.emptyList;

class Solution {

    // 并查集
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        return s;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (pre == null) {
                    pre = temp;
                } else {
                    pre.next = temp;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }

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
            return EMPTY_LIST;
        }
        int end = array.length;
        List<Integer> ans = new ArrayList<>();
        ans.addAll(Arrays.asList(first, second));
        while (first <= Integer.MAX_VALUE - second && begin < end) {
            int third = first + second;
            List<Integer> nums = getNumbers(third);
            if (begin + nums.size() > end) {
                return EMPTY_LIST;
            }
            for (int i = begin + nums.size() - 1; i >= begin ; i--) {
                if (array[i] - '0' != nums.get(begin + nums.size() - 1 - i)) {
                    return EMPTY_LIST;
                }
            }
            begin = begin + nums.size();
            //
            ans.add(third);
            first = second;
            second = third;
        }
        return begin == end && ans.size() > 2 ? ans : EMPTY_LIST;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) {
            return EMPTY_LIST;
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

    public String multiply(String num1, String num2) {
        int[] num = new int[num1.length() + num2.length() + 1];
        for (int i = 0; i < num1.length(); i++) {
            int val1 = num1.charAt(num1.length() - 1 - i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int val2 = num2.charAt(num2.length() - 1 - j) - '0';
                num[i + j] += val1 * val2;
            }
        }
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            int val = num[i] + flag;
            num[i] = val % 10;
            flag = val / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = num.length - 1; i >= 0 ; i--) {
            if (num[i] > 0) {
                for (int j = i; j >= 0 ; j--) {
                    sb.append(num[j]);
                }
                return sb.toString();
            }
        }
        return "0";
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = new ListNode(0), beforeCur = before, after = new ListNode(0), afterCur = after;
        while (head != null) {
            if (head.val < x) {
                beforeCur.next = head;
                beforeCur = beforeCur.next;
            } else {
                afterCur.next = head;
                afterCur = afterCur.next;
            }
            head = head.next;
        }
        beforeCur.next = after;
        return before.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        for (int i = 0; i < m; i++) {
            head = head.next;
        }
        ListNode first = null, second = head;
        while (second != null && m < n) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
            m++;
        }
        head.next = second;
        return pHead.next;
    }

    public int balancedStringSplit(String s) {
        int[] cnt = new int[2];
        int ans = 0;
        for (char ch : s.toCharArray()) {
            cnt[ch == 'L' ? 0 : 1]++;
            if (cnt[0] == cnt[1]) {
                ans++;
            }
        }
        return ans;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        if (queens.length == 0) {
            return EMPTY_LIST;
        }
        boolean[][] vis = new boolean[8][8];
        for (int[] queen : queens) {
            vis[queen[0]][queen[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = king[0] + i, y = king[1] + j;
                while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (vis[x][y]) {
                        ans.add(Arrays.asList(x, y));
                        break;
                    }
                    x += i;
                    y += j;
                }
            }
        }
        return ans;
    }

    private boolean isValid(Map<Integer, Set<Integer>> map) {
        Set<Integer> keySet = map.keySet();
        if (keySet.size() == 2) {
            Iterator<Integer> iterator = keySet.iterator();
            int maxKey = iterator.next(), minKey = iterator.next();
            if (maxKey < minKey) {
                int temp = maxKey;
                maxKey = minKey;
                minKey = temp;
            }
            return (maxKey - minKey == 1 && map.get(maxKey).size() == 1) || (minKey == 1 && map.get(minKey).size() == 1);
        } else {
            int key = keySet.iterator().next();
            return key == 1 || map.get(key).size() == 1;
        }
    }
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100005];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = 0, kSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt[num]++;
            if (cnt[num] > 1) {
                Set<Integer> oldKeySet = map.get(cnt[num] - 1);
                if (oldKeySet.size() == 1) {
                    map.remove(cnt[num] - 1);
                    kSize--;
                } else {
                    oldKeySet.remove(num);
                }
            }
            if (map.containsKey(cnt[num])) {
                map.get(cnt[num]).add(num);
            } else {
                kSize++;
                map.put(cnt[num], new HashSet(Arrays.asList(num)));
            }
            if (kSize < 3 && isValid(map)) {
                ans = i + 1;
            }
        }
        return ans;
    }

    public int missingNumber(int[] arr) {
        int d = -100005;
        if (arr.length == 3) {
            int first = arr[1] - arr[0], second = arr[2] - arr[1];
            if (first == 0) {
                d = 0;
            } else {
                d =  first / second > 1 ? second : first;
            }
        } else {
            int[] cnt = new int[2 * 100000 + 5];
            for (int i = 1; i < arr.length; i++) {
                int dis = arr[i] - arr[i - 1];
                if (cnt[dis + 100000] == 1) {
                    d = dis;
                    break;
                }
                cnt[dis + 100000]++;
            }
        }
        if (d == 0) {
            return arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return (arr[i] + arr[i - 1]) / 2;
            }
        }
        return -1;
    }

    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target; j++) {
                dp[i + 1][j] += (1 - prob[i]) * dp[i][j];
                dp[i + 1][j + 1] += prob[i] * dp[i][j];
            }
            dp[i + 1][target] += (1 - prob[i]) * dp[i][target];
        }
        return dp[n][target];
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        Arrays.sort(slots2, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0, j = 0; i < slots1.length && j < slots2.length; ) {
            if (slots1[i][1] <= slots2[j][0]) {
                i++;
            } else if (slots1[i][0] >= slots2[j][1]) {
                j++;
            } else {
                int begin = Math.max(slots1[i][0], slots2[j][0]), end = Math.min(slots1[i][1], slots2[j][1]);
                if (end - begin >= duration) {
                    return Arrays.asList(begin, begin + duration);
                }
                if (slots1[i][1] <= end) {
                    i++;
                }
                if (slots2[j][1] <= end) {
                    j++;
                }
            }
        }
        return new ArrayList<>();
    }

    private int binarySearch(int[] arr, int left, int right, int K) {
        int mid = 0, ans = Integer.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 0, cur = 0;
            for (int val : arr) {
                if (cur + val > mid) {
                    cnt++;
                    cur = val;
                } else {
                    cur += val;
                }
            }
            if (cur > 0) {
                cnt++;
            }
            if (cnt == K + 1) {
                for (int i = left; i < right; i++) {
                    int temp = 0;
                    for (int val : arr) {
                        if (temp + val <= mid) {
                            temp += val;
                        } else {
                            ans = Math.min(ans, temp);
                            temp = val;
                        }
                    }
                    ans = Math.min(ans, temp);
                }
                break;
            } else if (cnt > K + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int maximizeSweetness(int[] sweetness, int K) {
        if (K == 0) {
            return Arrays.stream(sweetness).sum();
        }
        int minVal = Arrays.stream(sweetness).min().getAsInt(), maxVal = Arrays.stream(sweetness).max().getAsInt();
        int left = Math.max(minVal * (sweetness.length / (K + 1)), maxVal), right = (sweetness.length / (K + 1) + 1) * maxVal + 1;
        return binarySearch(sweetness, left, right, K);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        int dx = coordinates[1][0] - coordinates[0][0], dy = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0] - coordinates[i - 1][0], y = coordinates[i][1] - coordinates[i - 1][1];
            if (dx * y != dy * x) {
                return false;
            }
        }
        return true;
    }

    public List<String> removeSubfolders(String[] folder) {
        if (folder.length <= 1) {
            return Arrays.asList(folder[0]);
        }
        Set<String> prefixSet = new HashSet<>();
        for (String path : folder) {
            char[] array = path.toCharArray();
            boolean ok = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == '/') {
                    String str = new String(array, 0, i);
                    if (prefixSet.contains(str)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                prefixSet.add(path);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String path : prefixSet) {
            char[] array = path.toCharArray();
            boolean ok = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == '/') {
                    String str = new String(array, 0, i);
                    if (prefixSet.contains(str)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                ans.add(path);
            }
        }
        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length <= 1) {
            return profit[0];
        }
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < startTime.length; i++) {
            ans.add(startTime[i]);
            ans.add(endTime[i]);
            map.put(startTime[i], endTime[i]);
        }
        ans = ans.stream().sorted().distinct().collect(Collectors.toList());
        int n = ans.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return -1;
    }

    public int tilingRectangle(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        return 0;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        Solution solution = new Solution();
        int n = 5, start = 31;
        System.out.println(solution);
    }
}
