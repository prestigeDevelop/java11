package threads;

public class PrintOddAndEven {

    static int N = 10;
    int counter = 0;

    public static void main(String[] args) {
        PrintOddAndEven printOddAndEven = new PrintOddAndEven();
        Runnable even = () -> {
            printOddAndEven.printEven();
        };
        Runnable odd = () -> {
            printOddAndEven.printOdd();
        };


        new Thread(odd).start();
        new Thread(even).start();
    }

    private void printEven() {

        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String threadName = Thread.currentThread().getName() + "EVEN";
                System.out.println(threadName + " " + counter);
                counter++;
                notify();

            }
        }
    }

    private void printOdd() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String threadName = Thread.currentThread().getName() + "ODD";
                System.out.println(threadName + " " + counter);
                counter++;
                notify();
            }
        }
    }


}
