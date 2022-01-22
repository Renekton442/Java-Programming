/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    public static long count(int[] a) {
        long num = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    num++;
            }
        }
        return num;
    }

    public static int[] generate(int n, long k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        int inv = 0;
        int j = n - 1;
        int s = 0;
        while (inv < k) {
            int temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
            inv++;
            j--;
            if (j == s) {
                j = n - 1;
                s++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
