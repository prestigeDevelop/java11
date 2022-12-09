package threads;

public class MyRunnable {

    public static void main(String[] args) {


        Runnable even = () -> {

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);

        };
        Runnable odd = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);

        };

        for (int i = 0; i < 10; i++) {
            new Thread(even).start();
            new Thread(odd).start();
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
