package _Arrays;

public class TwoDArrays {
    private static int ARRAY_SIZE;

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {6, 7, 8},
                {9, 10, 0},
                {9, 10, 0}};
        // returns the length of the rows in the array
        ARRAY_SIZE = arr.length;


        System.out.println(ARRAY_SIZE);

        printArray(arr);
        printArray(convertRowToZero(arr));

    }

    public static boolean findInColumn(int[][] matrix, int column, int n) {
        return false;
    }

    static int[][] convertRowToZero(int[][] arr) {
        // returns the length of the rows in the array
        int lengthOne = arr.length;
        // returns the length of the columns in the array
        int lengthTwo = arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    changeRow(arr, i);
                    changeColumn(arr, j);
                }
            }
        }
        return arr;
    }

    private static void changeRow(int[][] arr, int i) {
        for (int k = 0; k < arr[0].length; k++) {
            arr[i][k] = 0;
        }
    }

    private static void changeColumn(int[][] arr, int j) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[i][j] = 0;
        }
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                if (j == arr[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }


}
