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


