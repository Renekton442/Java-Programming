/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = 0;
        int[] count = new int[m + 1];
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            count[value]++;
            n++;
        }
        double entropy = 0.0;
        for (int j = 1; j <= m; j++) {
            double p = (double) count[j] / n;
            if (count[j] > 0)
                entropy -= p * Math.log(p) / Math.log(2);
        }
        StdOut.printf("%.4f%n", entropy);
    }
}
