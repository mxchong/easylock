package mxc.sdk.lock.single;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/4
 **/
public class SingleLock2 {
    public static boolean flag = true;
    public static StringBuffer s1 = new StringBuffer("123");

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                while (flag) {
                    System.out.println("t0 wait---------------------");
                    synchronized (s1) {
                        try {
                            s1.wait();
                            System.out.println("t0 awake!");
                            s1.notify();
                            flag = false;
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }, "t0");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (flag) {
                    System.out.println("t1 wait---------------------");
                    synchronized (s1) {
                        try {
                            s1.wait();
                            System.out.println("t1 awake!");
                            s1.notify();
                            flag = false;
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }, "t1");

        Thread.sleep(5000);

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (s1) {
                    System.out.println(s1);
                    s1.notify();
            }
            }
        }, "t2");
//        t0.start();
        t1.start();
        t2.start();
    }
}
