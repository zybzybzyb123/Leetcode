package Leetcode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// "static void main" must be defined in a public class.
public class Test {
    static int m, n;
    public static void main(String[] args) {
        char[][] input = new char[][]{ //
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        m = input.length;
        n = input[0].length;
        int globalMin = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j++) {
                if (input[i][j] == 'S')
                    q.add(new int[]{i, j});
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(bfs(input, q));
    }

    public static int bfs(char input[][], Queue<int[]> q) {
        int level = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{ 0, 0, 1, -1};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0 ; i < size ; i++) {
                int[] current = q.remove();
                input[current[0]][current[1]] = 'D';

                for (int j = 0 ; j < 4 ; j++) {
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];

                    if (x < 0 || y < 0 || x >= m || y >= n || input[x][y] == 'D')
                        continue;

                    if (input[x][y] == 'X')
                        return level + 1;

                    q.add(new int[]{x, y});
                }
            }

            level++;
        }

        return level;
    }
}

class ThreadTest {
    private void test() {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] print = {"first", "second", "third"};
        executorService.submit(() -> {
            try {
                foo.second(() -> System.out.println(print[1]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                foo.first(() -> System.out.println(print[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                foo.third(() -> System.out.println(print[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


