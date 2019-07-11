package mxc.sdk.lock.single;

/**
 * @Description synchronized用法1
 * @Author chenkaideng
 * @Date 2019/7/3
 **/
public class SingleLock implements Runnable{

    public static int NUM = 0;

    public static synchronized void increaseI() {
        NUM ++;
    }

    public synchronized void increaseII() {
        NUM ++;
    }

    public void run() {
        for (int j = 0; j < 100000; j++) {
            increaseI();
//            increaseII();
        }
    }

    public static void main (String[] args) throws InterruptedException{
        SingleLock singleLock = new SingleLock();
        Thread thread1 = new Thread(new SingleLock());
        Thread thread2 = new Thread(new SingleLock());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(SingleLock.NUM);
    }
}