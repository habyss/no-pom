package bf;

public class NotifyAndAll {

    public static void main(String[] args) {

        Thread wait1 = new Thread(new WaitThread(), "线程1");
        Thread wait2 = new Thread(new WaitThread(), "线程2");
        Thread notify1 = new Thread(new NotifyThread(), "线程3");
        wait1.start();
        wait2.start();
        notify1.start();
    }
}

class WaitThread implements Runnable {
    @Override
    public void run() {
        synchronized (NotifyAndAll.class) {
            try {
                NotifyAndAll.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait线程输出！" + Thread.currentThread().getName());
        }

    }
}

class NotifyThread implements Runnable {
    @Override
    public void run() {
        synchronized (NotifyAndAll.class) {
//            NotifyAndAll.class.notifyAll();
          NotifyAndAll.class.notify();
            System.out.println("notify线程输出" + Thread.currentThread().getName());
        }

    }
}