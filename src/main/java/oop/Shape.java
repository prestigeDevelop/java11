package oop;

public interface Shape {

    default int getSize(int x, int y) {
        return x * y;
    }

    void printSize(int x, int y);
}
