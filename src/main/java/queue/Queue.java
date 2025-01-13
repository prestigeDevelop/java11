package queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head; // head of the queue
    private Node<T> tail; // tail of the queue

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        head = null;
        tail = null;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
       // System.out.println(data);
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue q= new Queue();
        q.enqueue("hello1");
        q.enqueue("hello2");
        q.enqueue("hello3");
        q.enqueue("hello4");
        q.dequeue();
        System.out.println(q.peek());
    }
}
