package bf;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


class Worker implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private AtomicInteger finished;
    private Random random = new Random(47);
    private Semaphore semaphore;

    public Worker(Semaphore semaphore, AtomicInteger finished) {
        this.semaphore = semaphore;
        this.finished = finished;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this + " 占用一个机器在生产...   ");
            TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
            System.out.println(" 已经生产了" + finished.addAndGet(1) + "个产品," + "释放出机器");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "-" + id;
    }
}