package Leetcode;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
        Arrays.sort(points, (o2, o1) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] *
                o2[1]
        );

        int[][] ans = new int[K][2];
        System.arraycopy(points, 0, ans, 0, K);
        return ans;
    }

    private void init(Set<String> set) {
        for (int i = 0; i < 31; i++) {
            char[] array = String.valueOf(1 << i).toCharArray();
            Arrays.sort(array);
            set.add(new String(array));
        }
    }

    public boolean reorderedPowerOf2(int N) {
        Set<String> set = new HashSet<>();
        init(set);
        char[] array = String.valueOf(N).toCharArray();
        Arrays.sort(array);
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

    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
        }
        if (cnt == 0) {
            return;
        }
        int[] res = new int[arr.length];
        int id = 0;
        for (int i = 0; i < arr.length && id < arr.length; i++) {
            res[id++] = arr[i];
            if (arr[i] == 0) {
                res[id++] = 0;
            }
        }
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
    }
    int[][] dir = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[] vis = new boolean[10005];
        int len = grid.length;
        if(grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 1, leftNum = 1, cur = 0;
        while (!queue.isEmpty()) {
            leftNum--;
            int node = queue.poll();
            int x = node / 100, y = node % 100;
            if (x == grid.length - 1 && y == grid.length - 1) {
                return level;
            }
            for (int i = 0; i < dir.length; i++) {
                int x1 = x + dir[i][0];
                int y1 = y + dir[i][1];
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid.length && grid[x1][y1] ==
                        0 && !vis[x1 * 100 + y1]) {
                    vis[x1 * 100 + y1] = true;
                    queue.offer(x1 * 100 + y1);
                    cur++;
                }
            }
            if (leftNum == 0 && cur > 0) {
                level++;
                leftNum = cur;
                cur = 0;
            }
        }
        return -1;
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

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        return findInMountainArray(target, mountainArr, 0, len);
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
//        int[][] grid = {{0, 0, 0},{1, 1, 0}, {1, 1, 0}};
        System.out.println(solution);
    }
}
