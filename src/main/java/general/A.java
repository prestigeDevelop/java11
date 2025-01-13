package general;

class A {
    static {
        System.out.println("Static block in A");
    }

    {
        System.out.println("Instance block in A");
    }
}

class B extends A {
    static {
        System.out.println("Static block in B");
    }

    {
        System.out.println("Instance block in B");
    }

    public static void main(String[] args) {
        B b = new B();

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(matrix1[2][0]);
        System.out.println(process(matrix1));
        System.out.println(calculate(5));
    }

    public static int process(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            sum += matrix[i][n - 1 - i];
        }
        if (n % 2 == 1) {
            sum -= matrix[n / 2][n / 2];
        }
        return sum;
    }
   //5
    public static int calculate(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (i == 3) {
                sum += calculate(i - 1);
            }
        }
        return sum;
    }

}
