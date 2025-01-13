package stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayStack<T> {
    private T[] arr;
    private int top; // Index of the top element
    private int capacity;
    public ArrayStack(int capacity) {
        arr = (T[]) new Object[capacity];
        top = -1; // Indicates an empty stack
        this.capacity=capacity;
    }

    public void push(T data) {
        if (top == arr.length - 1) {
            throw new StackOverflowError("Stack is full.");
        }
        arr[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity-1;
    }
    // Helper method to print the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
        System.out.println("-------");
    }

    // Example usage in main method
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.printStack();
        // Print before pops
        stack.pop();
        stack.pop();
        //System.out.println("Popped: " + stack.pop());
       // stack.printStack();
        //System.out.println("Popped: " + stack.pop());
       // stack.printStack();
       // System.out.println("Peeked: " + stack.peek());
        stack.push(6);
        stack.printStack();
    }
}
