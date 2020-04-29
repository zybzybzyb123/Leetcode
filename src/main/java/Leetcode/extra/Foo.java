package Leetcode.extra;

/**
 * @author zero
 * @created 2020/04/29
 */
public class Foo {

    public Foo() {
        
    }
    private volatile int val = 0;
    public void first(Runnable printFirst) throws InterruptedException {
        long cnt = 0;
        while (val != 0) {
            cnt++;
//            System.out.println("first : " + val);
        }
        Thread.sleep(100L);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        System.out.printf("cnt1=%d\n", cnt);
        val++;
//        val.compareAndSet(0, 1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        long cnt = 0;
        while (val != 1) {
//            Thread.sleep(1);
            cnt++;
//            System.out.println("second : " + val);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        System.out.printf("cnt2=%d\n", cnt);
        val++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        long cnt = 0;
        while (val != 2) {
//            Thread.sleep(1);
            cnt++;
//            System.out.println("third : " + val);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        System.out.printf("cnt3=%d\n", cnt);
    }
//    Semaphore semaphore = new Semaphore(2);
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        while(semaphore.availablePermits() != 2){}
//        Thread.sleep(100L);
//        printFirst.run();
//        semaphore.acquire();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while(semaphore.availablePermits() != 1){}
//
//        printSecond.run();
//
//        semaphore.acquire();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while(semaphore.availablePermits() != 0){}
//
//        printThird.run();
//
//        semaphore.release(2);
//    }
}