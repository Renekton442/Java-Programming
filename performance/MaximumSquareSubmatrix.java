/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int[][] matrix = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            matrix[i][0] = a[i][0];
        }
        for (int j = 0; j < a[0].length; j++) {
            matrix[0][j] = a[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (a[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i][j - 1],
                                            Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;
                else
                    matrix[i][j] = 0;
            }
        }
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}
