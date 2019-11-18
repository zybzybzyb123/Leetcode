package Leetcode;

import Leetcode.dataStructure.base.ListNode;
import Leetcode.dataStructure.base.Node;
import Leetcode.dataStructure.base.TreeNode;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static java.util.stream.Collectors.toList;

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
        return null;
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
        ans = ans.stream().sorted().distinct().collect(toList());
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

    public int balancedString(String s) {
        int[] cnt = new int[100];
        char[] array = s.toCharArray();
        for (char ch : array) {
            cnt[ch]++;
        }
        int i = 0, avg = array.length / 4, ans = array.length + 1;
        for (int j = 0; j < array.length; j++) {
            if (cnt['Q'] <= avg && cnt['W'] <= avg && cnt['E'] <= avg && cnt['R'] <= avg) {
                ans = Math.min(ans, j - i + 1);
                i++;
            }
            cnt[array[j]]--;
        }
        return array.length - i;
    }

    public List<Integer> transformArray(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    flag = true;
                    temp[i] = arr[i] + 1;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    flag = true;
                    temp[i] = arr[i] - 1;
                }
            }
            if (flag) {
                for (int i = 1; i < arr.length - 1; i++) {
                    arr[i] = temp[i];
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    class Leaderboard {

//        private int topSum, topLowerScore;
        private Map<Integer, Integer> scoreMap;
        private Map<Integer, Integer> playerMap;

        public Leaderboard() {
            scoreMap = new TreeMap<>((a, b) -> b - a);
            playerMap = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            if (playerMap.containsKey(playerId)) {
                int oldScore = playerMap.get(playerId);
                int oldScoreCnt = scoreMap.get(oldScore);
                if (oldScoreCnt == 1) {
                    scoreMap.remove(oldScore);
                } else {
                    scoreMap.put(oldScore, oldScoreCnt - 1);
                }
                scoreMap.put(oldScore + score, scoreMap.getOrDefault(oldScore + score, 0) + 1);
                playerMap.put(playerId, oldScore + score);
            } else {
                playerMap.put(playerId, score);
                scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
            }
        }

        public int top(int K) {
            int topSum = 0;
            for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
                int curScore = entry.getKey();
                int curScoreCnt = entry.getValue();
                if (K > curScoreCnt) {
                    topSum += curScoreCnt * curScore;
                    K -= curScoreCnt;
                } else {
                    topSum += K * curScore;
                    break;
                }
            }
            return topSum;
        }

        public void reset(int playerId) {
            int score = playerMap.get(playerId);
            int scoreCnt = scoreMap.get(score);
            if (scoreCnt == 1) {
                scoreMap.remove(score);
            } else {
                scoreMap.put(score, scoreCnt - 1);
            }
            playerMap.remove(playerId);
        }
    }

    private int bfs (int u, Map<Integer, List<Integer>> edgeMap, Set<Integer> pointSet) {
        int ans = u;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        pointSet.add(u);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int v : edgeMap.get(temp)) {
                    if (!pointSet.contains(v)) {
                        pointSet.add(v);
                        queue.offer(v);
                        ans = v;
                    }
                }
            }
        }
        return ans;
    }

    private int dfs (int u, Map<Integer, List<Integer>> edgeMap, Set<Integer> pointSet) {
        pointSet.add(u);
        int ans = 0;
        for (int v : edgeMap.get(u)) {
            if (!pointSet.contains(v)) {
                ans = Math.max(ans, dfs(v, edgeMap, pointSet) + 1);
            }
        }
        return ans;
    }

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Set<Integer> pointSet = new HashSet<>();
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int u = bfs(0, edgeMap, pointSet);
        pointSet.clear();
        return dfs(u, edgeMap, pointSet);
    }

    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    cnt1++;
                } else {
                    cnt2++;
                }
            }
        }
        if (((cnt1 + cnt2) & 1) == 1) {
            return -1;
        } else {
            if ((cnt1 & 1) == 0) {
                return (cnt1 + cnt2) >> 1;
            } else {
                return ((cnt1 + cnt2) >> 1) + 1;
            }
        }
    }

    public String minRemoveToMakeValid(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else if (array[i] == ')') {
                if (stack.isEmpty()) {
                    array[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            array[stack.poll()] = '*';
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*') {
                ans.append(array[i]);
            }
        }
        return ans.toString();
    }

    private int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    public boolean isGoodArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 1;
        }
        int ans = gcd(nums[0], nums[1]);
        for (int i = 2; i < nums.length && ans != 1; i++) {
            ans = gcd(ans, nums[i]);
        }
        return ans == 1;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        pos.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                pos.add(i);
            }
        }
        pos.add(nums.length);
        if (pos.size() < k + 2) {
            return 0;
        }
        int begin = 1, end = k, ans = 0;
        while (end < pos.size() - 1) {
            ans += (pos.get(begin) - pos.get(begin - 1)) * (pos.get(end + 1) - pos.get(end));
            begin++;
            end++;
        }
        return ans;
    }


    private int getMaxLengthSeq(int[] arr, int n, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[n - 1 - j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        if (dp[n][n] == n) {
            return 0;
        }
        int from = n, to = n, id = 0;
        Set<Integer> pos = new HashSet<>();
        while (dp[from][to] > 0) {
            if (dp[from][to] == dp[from][to - 1]) {
                to--;
            } else if (dp[from][to] == dp[from - 1][to]) {
                from--;
            } else {
                pos.add(from - 1);
                from--;
                to--;
            }
        }
        System.out.println(pos);
        for (int i = 0; i < n; i++) {
            if (!pos.contains(i)) {
                arr[id++] = arr[i];
            }
        }
        return id;
    }

    public int minimumMoves(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int ans = 0, len = arr.length;
        int[][] dp = new int[len + 1][len + 1];
        do {
            len = getMaxLengthSeq(arr, len, dp);
            ans++;
        } while (len > 0);
        return ans;
    }

    private void solve(int[] num, int begin, int end, int[] temp) {
        if (end - begin <= 2) {
            return;
        }
        int pos = (end - begin + 1) >> 1;
        for (int i = begin; i < end; i += 2) {
            temp[begin + ((i - begin) >> 1)] = num[i];
            if (i < end - 1) {
                temp[begin + pos + ((i - begin) >> 1)] = num[i + 1];
            }
        }
        for (int i = begin; i < end; i++) {
            num[i] = temp[i];
        }
        solve(num, begin, begin + pos, temp);
        solve(num, begin + pos, end, temp);
    }

    public int[] beautifulArray(int N) {
        int[] num = new int[N], temp = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        if (N <= 2) {
            return num;
        }
        solve(num, 0, N, temp);
        return num;
    }

    private boolean solve(int x, int y, int sx, int sy) {
        return true;
    }
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        return solve(tx, ty, sx, sy);
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int r = indices[i][0], c = indices[i][1];
            for (int j = 0; j < n; j++) {
                grid[j][c]++;
            }
            for (int j = 0; j < m; j++) {
                grid[r][j]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((grid[i][j] & 1) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        for (int i = 0; i < colsum.length; i++) {
            sum += colsum[i];
        }
        if (upper + lower != sum || upper > colsum.length || lower > colsum.length) {
            return Collections.EMPTY_LIST;
        }
        int[] mat1 = new int[colsum.length], mat2 = new int[colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                if (upper <= 0 || lower <= 0) {
                    return Collections.EMPTY_LIST;
                }
                upper--;
                lower--;
                mat1[i] = mat2[i] = 1;
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upper--;
                    mat1[i] = 1;
                } else {
                    lower--;
                    mat2[i] = 1;
                }
            }
        }
        List<Integer> list1 = Arrays.stream(mat1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(mat2).boxed().collect(Collectors.toList());
        return Arrays.asList(list1, list2);
    }

    private int[][] dirs = {{0, 1}, {0, -1}, {1,  0}, {-1, 0}};

    private boolean dfs(int x, int y, int[][] grid) {
        grid[x][y] = 1;
        int n = grid.length, m = grid[0].length;
        boolean ans = true;
        for (int[] dir : dirs) {
            int rx = x + dir[0], ry = y + dir[1];
            if (rx >= 0 && rx < n && ry >= 0 && ry < m && grid[rx][ry] == 0) {
                boolean res = dfs(rx, ry, grid);
                ans &= res;
            }
        }
        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
            return false;
        }
        return ans;
    }

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int cur, String[] words, int[] score, int[] wordCnt, int[] cnt) {
        if (cur == words.length) {
            return 0;
        }
        int ans = dfs(cur + 1, words, score, wordCnt, cnt);
        int wordScore = 0;
        int[] tempCnt = new int[26];
        char[] array = words[cur].toCharArray();
        for (int i = 0; i < array.length; i++) {
            int pos = array[i] - 'a';
            tempCnt[pos]++;
            if (wordCnt[pos] + tempCnt[pos] > cnt[pos]) {
                wordScore = 0;
                break;
            }
            wordScore += score[pos];
        }
        if (wordScore > 0) {
            for (int i = 0; i < tempCnt.length; i++) {
                if (tempCnt[i] > 0) {
                    wordCnt[i] += tempCnt[i];
                }
            }
            ans = Math.max(ans, wordScore + dfs(cur + 1, words, score, wordCnt, cnt));
            for (int i = 0; i < tempCnt.length; i++) {
                if (tempCnt[i] > 0) {
                    wordCnt[i] -= tempCnt[i];
                }
            }
        }
        return ans;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int ans = 0;
        int[] cnt = new int[26];
        for (char letter : letters) {
            cnt[letter - 'a']++;
        }
        return dfs(0, words, score, new int[26], cnt);
    }

    public String encode(int num) {
        String str = Integer.toBinaryString(num);
//        System.out.println('str = ' + str);
        if ((num & 1) == 1) {
            StringBuilder temp = new StringBuilder();
            for (char ch : str.toCharArray()) {
                temp.append(ch == '0' ? '1' : '0');
            }
            str = temp.toString();
            System.out.println(str);
            int pos = str.indexOf('1');
            return pos > 0 ? str.substring(pos) : str;
        } else {
            return new StringBuffer(str.substring(0, str.length() - 1)).reverse().toString();
        }
    }

    class FindElements {

        private Set<Integer> nodes;
        public FindElements(TreeNode root) {
            nodes = new HashSet<>();
            root.val = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                nodes.add(cur.val);
                if (cur.left != null) {
                    cur.left.val = 2 * cur.val + 1;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = 2 * cur.val + 2;
                    queue.add(cur.right);
                }
            }
        }

        public boolean find(int target) {
            return nodes.contains(target);
        }
    }

    private static final int COL = 100;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1},  {-1, 0}};
    private int findPos(char ch, char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    return i * COL + j;
                }
            }
        }
        return -1;
    }

    private boolean[] checkDirs(int person, int box, char[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] res = new boolean[4];
        int n = grid.length, m = grid[0].length;
        Set<Integer> set = new HashSet<>();
        queue.add(person);
        set.add(box);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            set.add(cur);
            int x = cur / COL, y = cur % COL;
            boolean ok = false;
            for (int i = 0; i < dir.length; i++) {
                if (cur == box + dir[i][0] * COL + dir[i][1]) {
                    res[i] = true;
                }
                if (!res[i]) {
                    ok = false;
                }
            }
            if (ok) {
                break;
            }
            for (int i = 0; i < dir.length; i++) {
                int rx = x + dir[i][0], ry = y + dir[i][1];
                if (rx >= 0 && rx < n && ry >= 0 && ry < m &&  grid[rx][ry] != '#' && !set.contains(rx * COL + ry)) {
                    queue.add(rx * COL + ry);
                }
            }
        }
        return res;
    }

    public int minPushBox(char[][] grid) {
        int box = findPos('B', grid);
        int person = findPos('S', grid);
        int des = findPos('T', grid);
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n * COL + m][4];
        queue.add(new int[]{person, box});
        int ans = -1, step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] personAndBoxPos = queue.poll();
                int curPerson = personAndBoxPos[0];
                int curBox = personAndBoxPos[1];

                Arrays.fill(vis[curBox], true);
                if (curBox == des) {
                    return step;
                }
                int x = curBox / COL, y = curBox % COL;
                boolean[] isArriveDirs = checkDirs(curPerson, curBox, grid);
                for (int j = 0; j < dir.length; j++) {
                    if (isArriveDirs[j]) {
                        int x1 = x + dir[(j + 2) % 4][0], y1 = y + dir[(j + 2) % 4][1];
                        if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m &&  grid[x1][y1] != '#' && !vis[x1 * COL + y1][(j + 2) % 2]) {
                            vis[x1 * COL + y1][(j + 2) % 2] = true;
                            vis[curBox][j] = true;
                            queue.offer(new int[] {curBox, x1 * COL + y1});
                        }
                    }
                }
            }
            step++;
        }
        return ans;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        Solution solution = new Solution();
        int sx = 2, sy = 9, tx = 5, ty = 11;
        int[] colsum = {0,1,2,0,0,0,0,0,2,1,2,1,2};
        int upper = 9, lower = 2;

//        System.out.println(solution.reachingPoints(sx, sy, tx, ty));
        char[][] grid =
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','#','#','#','#','#','#','#','#'},
                        {'#','.','.','.','#','#','.','#','#','#','#','.','#','#','#','.','#','#','T','#'},
                        {'#','.','.','.','.','.','.','#','.','#','.','.','#','#','#','.','#','#','.','#'},
                        {'#','.','.','.','#','.','.','.','.','.','.','.','#','#','#','.','#','#','.','#'},
                        {'#','.','#','.','.','.','.','.','.','.','.','.','#','#','#','.','#','#','.','#'},
                        {'#','.','#','.','#','#','#','#','#','#','#','.','#','#','#','.','#','#','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','B','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','.','.','.','.','.','.','.','S','.','.','.','.','.','.','.','#','.','.','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
                };

        int[] num = {1,2,3,4,4};
        System.out.println(solution);
    }
}
