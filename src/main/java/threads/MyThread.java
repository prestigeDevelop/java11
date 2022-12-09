package threads;

public class MyThread extends Thread {
    MyThread(String str) {
        super(str);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Canada");
        t1.setPriority(MyThread.NORM_PRIORITY);
        t1.start();

        MyThread t2 = new MyThread("USA");
        t2.setPriority(MyThread.MIN_PRIORITY);
        t2.start();

        MyThread t3 = new MyThread("MEXICO");
        t3.setPriority(MyThread.MAX_PRIORITY);
        t3.start();

        // System.out.println("This code is outside of the thread");
    }

    public void run() {
        System.out.println("This code is running in a thread");
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + getName());
//            try {
//                sleep((int)(Math.random()*100));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(getName() + " DONE");
    }
}
