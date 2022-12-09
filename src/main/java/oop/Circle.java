package oop;

public class Circle implements Shape {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.printSize(4, 5);
    }

    @Override
    public void printSize(int x, int y) {
        System.out.println(getSize(x, y));
    }
}
