package threads;

import stack.ArrayStack;

public class Producer {
    private ArrayStack arrayStack;
    Object lock =new Object();
    private int data=0;
    public Producer(ArrayStack arrayStack) {
        this.arrayStack = arrayStack;
    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (arrayStack.isFull()) {
                    lock.wait();
                } else {
                    try {
                        arrayStack.push(++data);
                        System.out.println("Pushed:"+data);
                    }catch (StackOverflowError e){
                        e.printStackTrace();
                        lock.wait();
                    }
                    lock.notify();
                }
               // Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock){
            while (true) {
                if (arrayStack.isEmpty()) {
                    lock.wait();
                } else {
                    System.out.println("poped: " + arrayStack.pop());
                    lock.notify();
                }
                //Thread.sleep(400);
            }
        }
    }
   public Thread producerThread = new Thread(() -> {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    public Thread consumerThread = new Thread(() -> {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    public Thread consumerThread1 = new Thread(() -> {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    public static void main(String[] args) throws InterruptedException {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        Producer p =new Producer(stack);
        p.producerThread.start();
        p.consumerThread.start();
        p.consumerThread1.start();
        p.producerThread.join();
        p.consumerThread.join();
        p.consumerThread1.join();
    }
}
