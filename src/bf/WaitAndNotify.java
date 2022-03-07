package bf;

import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
    public static void main(String[] args) {
        Object lock = new Object();
        System.out.println(lock);

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, lock);
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");
            synchronized (lock) {
                lock.notifyAll();
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        private String name;
        private Object lock;

        public MyThread(String name, Object lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.out.println(name + " is waiting.");
            try {
                synchronized (lock) {
                    lock.wait();
                }
                System.out.println(name + " has been notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}