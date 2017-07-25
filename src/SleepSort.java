import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepSort {

    public static void sort(int[] array) {
        final int LEN = array.length;
        ArrayList<Integer> al = new ArrayList<>(LEN);
        CyclicBarrier cb = new CyclicBarrier(LEN);
        Lock lock = new ReentrantLock();
        final CountDownLatch cdl = new CountDownLatch(LEN);

        for (int i = 0; i < LEN; i++) {
            final int val = array[i];
            new Thread(() -> {
                try {
                    int sleep = val * 10;
                    cb.await();
                    Thread.sleep(sleep);
                    lock.tryLock(10, TimeUnit.SECONDS);
                    al.add(val);
                    lock.unlock();
                    cdl.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

        try {
            cdl.await();
            System.out.println(al);
            System.out.println(al.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
