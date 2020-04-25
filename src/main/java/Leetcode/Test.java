package Leetcode;

import Leetcode.extra.Foo;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

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


