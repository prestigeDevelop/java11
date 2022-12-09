package _Arrays;

import java.util.Optional;

public class ArrayOperations {

    private int[] products;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void initializeArray(int size) {
        products = new int[size];
    }

    public Optional<Integer> searchItem(int item) {
        //return  Arrays.stream(products).filter(i->i==item).findFirst();
        for (int i = 0; i < products.length; i++) {
            if (item == products[i]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * remove the item by index
     *
     * @param index
     */
    public boolean removeItem(int index) {
        boolean wasRemoved = false;
        for (int z = 0; z < size; z++) {
            if (z == index) {
                products[z] = 0;
                printArray();
                wasRemoved = true;
                return wasRemoved;
            }
        }
        return wasRemoved;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("Product %d number: %d", i, getProducts()[i]));
        }
    }

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }
}
