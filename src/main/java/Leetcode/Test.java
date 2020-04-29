package Leetcode;

import Leetcode.extra.Foo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zero
 * @created 2020/04/29
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/Leetcode/in.txt";
        FileInputStream inputStream = new FileInputStream(filePath);
        System.setIn(new BufferedInputStream(inputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int[] nums = new int[n];
        int sum = 0;
        String res = reader.readLine();
        String[] array = res.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(array[i]);
            sum += nums[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2 - nums[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + nums[i]] = true;
                    ans = Math.max(ans, j + nums[i]);
                }
            }
        }
        System.out.println(Math.abs(sum - 2 * ans));
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


