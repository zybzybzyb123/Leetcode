package Leetcode;

import static java.util.Arrays.sort;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//CHECKSTYLE:OFF
class Solution {
    public int longestSubstring(String s, int k) {
        return 0;
    }
    public int[] beautifulArray(int N) {
        return null;
    }
    public int largestOverlap(int[][] A, int[][] B) {
        int[] cnt = new int[2000];
        int len1 = 0, len2 = 0;
        System.out.format("A len : %d\n", A.length);
        int[] pos1 = new int[A.length * A.length + 10];
        int[] pos2 = new int[pos1.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1[len1++] = i * 30 + j;
                }
                if (B[i][j] == 1) {
                    pos2[len2++] = i * 30 + j;
                }
            }
        }
        int ans = 0;
        System.out.format("len1 = %d, len2 = %d\n", len1, len2);
        System.out.format("pos1 = %s\n", Arrays.stream(pos1).limit(len1).boxed().collect(toList()));
        System.out.format("pos2 = %s\n", Arrays.stream(pos2).limit(len2).boxed().collect(toList()));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
//                System.out.format("pos2[j] - pos1[i] = %d\n", pos2[j] - pos1[i]);
                cnt[pos2[j] - pos1[i] + 1000]++;
                ans = Math.max(cnt[pos2[j] - pos1[i] + 1000], ans);
            }
        }
        return ans;
    }

    public int largestOverlap1(int[][] A, int[][] B) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1.add(i * 32 + j);
                }
                if (B[i][j] == 1) {
                    pos2.add(i * 32 + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < pos1.size(); i++) {
            for (int j = 0; j < pos2.size(); j++) {
                int key = pos2.get(j) - pos1.get(i);
                int val = cnt.getOrDefault(key,0);
                if (val == 481) {
                    System.out.printf("pos1 = %d, pos2 = %d\n", pos1.get(i), pos2.get(j));
                }
                ans = Math.max(val + 1, ans);
                cnt.put(key, val + 1);
            }
        }
        return ans;
    }

    public boolean isValid(String S) {
        LinkedList<Integer> stash = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            int val = ch - 'a';
            if (val == 0) {
                stash.push(val);
            } else if (val == 1) {
                if (stash.size() < 1 || stash.peek() != 0) {
                    return false;
                }
                stash.push(val);
            } else {
                if (stash.size() < 2) {
                    return false;
                }
                int x = stash.pop(), y = stash.pop();
                if (x != 1 || y != 0) {
                    return false;
                }
            }
        }
        return stash.isEmpty();
    }

    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] * o2[1];
//            }
//        });
        sort(points, (o2, o1) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] *
                o2[1]
        );

        int[][] ans = new int[K][2];
        System.arraycopy(points, 0, ans, 0, K);
        return ans;
    }

    private void init(Set<String> set) {
        for (int i = 0; i < 31; i++) {
            char[] array = String.valueOf(1 << i).toCharArray();
            sort(array);
            set.add(new String(array));
        }
    }

    public boolean reorderedPowerOf2(int N) {
        Set<String> set = new HashSet<>();
        init(set);
        char[] array = String.valueOf(N).toCharArray();
        sort(array);
        return set.contains(new String(array));
    }

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

    private int dfs(int[] array) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] == 0) {
                continue;
            }
            array[i]--;
            sum = sum + dfs(array) + 1;
            array[i]++;
        }
        return sum;
    }

    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            cnt[tiles.charAt(i) - 'A']++ ;
        }
        return dfs(cnt);
    }

//    public int maxSumAfterPartitioning(int[] A, int K) {
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i < K; i++) {
//            while (!deque.isEmpty() && deque.peekFirst() <= A[i]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//        }
//        int sum = deque.peekFirst() * K;
//        for (int i = K; i < A.length; i++) {
//            if ()
//        }
//        return sum;
//    }

    public int findInMountainArray(int target, MountainArray mountainArr, int left, int right) {
        int mid = (left + right) / 2;
        while (left < right) {
            if (mountainArr.get(mid) == target) {
                return mid;
            }
        }
        return -1;
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0] - 1; j <= bookings[i][1] - 1; j++) {
                ans[j] += bookings[i][2];
            }
        }
        return ans;
    }

    public List<TreeNode> solve(TreeNode preRoot, TreeNode root, Set<Integer> deleteSet) {
        List<TreeNode> ans = new ArrayList<>();
        if (preRoot == null && !deleteSet.contains(root.val)) {
            ans.add(root);
        }

        preRoot = deleteSet.contains(root.val) ? null : root;
        if (root.left != null) {
            ans.addAll(solve(preRoot, root.left, deleteSet));
            if (deleteSet.contains(root.left.val)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            ans.addAll(solve(preRoot, root.right, deleteSet));
            if (deleteSet.contains(root.right.val)) {
                root.right = null;
            }
        }
        return ans;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        Set<Integer> deleteSet = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            deleteSet.add(to_delete[i]);
        }
        return solve(null, root, deleteSet);
    }

//    public int[] maxDepthAfterSplit(String seq) {
//        LinkedList<Integer> stack = new LinkedList<>();
//        int rank = 0, curDep = -1, cur = 0;
//        int[] cnt = new int[10005];
//        char[] array = seq.toCharArray();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == '(') {
//
//            }
//        }
//    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        return findInMountainArray(target, mountainArr, 0, len);
    }

    private int findK(int a1, int m, int k) {
        for (int i = 1; ;i++) {
            int value = a1 * i + m * m * i * (i - 1) / 2;
            if (value > k) {
                return i - 1;
            }
        }
    }

    public int longestWPI(int[] hours) {
        int cnt = 0, ans = 0, len = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                cnt++;
                len++;
            } else {
                if (cnt > 1) {
                    len++;
                }
                cnt = Math.max(cnt - 1, 0);
            }
        }
        return ans;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] array = new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            int x = dominoes[i][0];
            int y = dominoes[i][1];
            array[x][y]++;
            if (x != y) {
                array[y][x]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i ; j++) {
                ans += array[j][i] * (array[j][i] - 1) / 2;
            }
        }
        return ans;
    }

    public int mctFromLeafValues(int[] arr) {
        int ans = 0, sz = arr.length;
        while (sz > 1) {
            int id = 0, Min = 300, pos = 0;
            for (int i = 1; i < sz; i++) {
                int val = arr[i] * arr[i - 1];
                if (val < Min) {
                    pos = i - 1;
                    Min = val;
                }
            }
            ans += Min;
            for (int i = 0; i < sz; i++) {
                if (i == pos) {
                    arr[id++] = Math.max(arr[pos], arr[pos + 1]);
                    i++;
                } else {
                    arr[id++] = arr[i];
                }
            }
            sz--;
        }
        return ans;
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][][] dp = new int[105][105][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j][0] = dp[i][j][1] = -1;
                }
            }
        }
        for (int i = 0; i < red_edges.length; i++) {
            int x = red_edges[i][0];
            int y = red_edges[i][1];
            if (x != y) {
                dp[x][y][0] = 1;
            }
        }
        for (int i = 0; i < blue_edges.length; i++) {
            int x = blue_edges[i][0];
            int y = blue_edges[i][1];
            if (x != y) {
                dp[x][y][1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("dp[%d][%d]=%d ", i, j, dp[i][j][0]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i][k][1] + dp[k][j][0]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][k][0] + dp[k][j][1]);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            if (dp[0][i][0] > 0 && dp[0][i][1] > 0) {
                ans[i] = Math.min(dp[0][i][0], dp[0][i][1]);
            } else if (dp[0][i][0] > 0) {
                ans[i] = dp[0][i][0];
            } else if (dp[0][i][1] > 0) {
                ans[i] = dp[0][i][1];
            }
        }
        return ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = piles[i];
                }

            }
        }
        return 0;
    }

    private int getMaxSqure(int[][] dp, int cur, int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        int maxSqure = Math.min(dp[i][j] / 200, dp[i][j] % 200);
//        System.out.format("i=%d, j=%d, maxSqure=%d\n", i, j, maxSqure);
        if (maxSqure <= cur) {
            return cur;
        }
        for (int k = maxSqure; k > cur ; k--) {
            if (dp[i - k + 1][j] % 200 >= k && dp[i][j - k + 1] / 200 >= k) {
                return k;
            }
        }
        return cur;
    }

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] % 200 + dp[i - 1][j] / 200 * 200 + 201;
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j] / 200 * 200 + 201;
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1] % 200 + 201;
                    } else {
                        dp[i][j] = 201;
                    }
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf("dp[%d][%d]=%d ", i, j, dp[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(getMaxSqure(dp, ans, i, j), ans);
//                    System.out.format("i=%d, j=%d, ans=%d\n", i, j, ans);
                }
            }
        }
        return ans * ans;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
//        System.out.println(solution.queryString("0110", 3));
//        int[][] A = {};
//        int[][] B = {};
//        System.out.println(solution.largestOverlap(A, B));
//        String str = "abcabcababcc";
        int n = 3;
        int[][] red_edges = {{0,1},{1,2}}, blue_edges = {};
        int[] piles = {2,7,9,4,4};
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(solution.largest1BorderedSquare(grid));
    }
}
