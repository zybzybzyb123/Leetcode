package Leetcode.extra;

public class H2O {
    private static volatile int cnt = 0;
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (cnt % 3 == 2);
        releaseHydrogen.run();
        cnt++;
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (cnt % 3 != 2);
        releaseOxygen.run();
        cnt++;
    }
}