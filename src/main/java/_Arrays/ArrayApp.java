package _Arrays;

import javax.swing.*;
import java.util.stream.IntStream;

import static _Arrays.ArrayApp.VillageFestivalNumbers.villageFestivalNumbers;

// I dont want this line
public class ArrayApp {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println( villageFestivalNumbers(new int[]{1,2,3,4,5},2)[i]);
        }
        int[]  input1 = new int[]{0,1,2,3,4,5};
        input1 =IntStream.of(input1).filter(arr->arr!=0).toArray();
        ArrayOperations arrayOperations = new ArrayOperations();
        int[] array = null;
        Integer storeSize = 0;

        boolean isError = true;
        String input = null;
        while (isError) {
            try {
                input = JOptionPane.showInputDialog("How many products your store includes?");
                storeSize = Integer.parseInt(input);
                isError = false;
            } catch (NumberFormatException e) {
                if (input == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Not a valid input.Please enter a numeric value");
            }
        }
        arrayOperations.setSize(storeSize);
        arrayOperations.initializeArray(storeSize);
        array = new int[storeSize];
        Integer item = null;
        for (int i = 0; i < storeSize; i++) {
            try {
                item = Integer.parseInt(JOptionPane.showInputDialog("Enter product number: " + i));
                array[i] = item;
            } catch (NumberFormatException e) {
                if (item == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Not a valid input.Please enter a numeric value");

            }
        }
        arrayOperations.setProducts(array);
        arrayOperations.printArray();

        //int searchQ=Integer.parseInt(JOptionPane.showInputDialog("Do you want to search for a product? 1-Yes,2-No"));
        int searchQ = JOptionPane.showConfirmDialog(
                null,
                "Do you want to search for a product?",
                "Search Product?",
                JOptionPane.YES_NO_OPTION);
        //0 is yes and 1 is no

        //3. search
        if (searchQ == 0) {
            isError = true;
            while (isError) {
                try {
                    input = JOptionPane.showInputDialog("Which product you want to search?");
                    int itemToSearch = Integer.parseInt(input);
                    isError = false;
                    Integer searchResult = arrayOperations.searchItem(itemToSearch).orElseGet(null);
                    //Integer searchResult= arrayOperations.searchItem(itemToSearch).orElse()
                    if (searchResult != null) {
                        JOptionPane.showConfirmDialog(
                                null,
                                "The product is available at index:" + searchResult,
                                "Message",
                                JOptionPane.CLOSED_OPTION);
                    } else {
                        JOptionPane.showConfirmDialog(
                                null,
                                "The product was not found",
                                "Message",
                                JOptionPane.CLOSED_OPTION);
                    }
                } catch (NumberFormatException e) {
                    if (input == null) {
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Not a valid input.Please enter a numeric value to search");
                }
            }
        }
        //4.  remove item
        int removeQuestion = JOptionPane.showConfirmDialog(
                null,
                "Do you want to remove product?",
                "Remove Product?",
                JOptionPane.YES_NO_OPTION);
        if (removeQuestion == 0) {
            int itemToremove = Integer.parseInt(JOptionPane.showInputDialog("Which product you want to remove(Enter the index number :0-" + (arrayOperations.getSize() - 1) + ")?"));
            if (itemToremove > arrayOperations.getSize() - 1) {
                JOptionPane.showMessageDialog(null, "The index you entered does not exist");
            }
            boolean wasRemoved = arrayOperations.removeItem(itemToremove);
            if (wasRemoved) {
                JOptionPane.showMessageDialog(null, "The product was removed from the list");
            }
        }

    }
    class VillageFestivalNumbers {
        public static int[] villageFestivalNumbers(int[] numbers, int k) {
            int sum = IntStream.of(numbers).sum();
            double average = sum/numbers.length;
            int[] resultArr = new int[numbers.length];
            int counter=0;
            for(int i=0;i<numbers.length;i++){
                int current = numbers[i];
                if(current>k && current%k==0){
                    resultArr[counter]=current;
                    counter++;
                }

            }
            return resultArr;
        }
    }
}
