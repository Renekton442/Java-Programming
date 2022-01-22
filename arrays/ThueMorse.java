/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] thue = { 0 };
        for (int i = 1; i <= n; i *= 2) {
            thue = Arrays.copyOf(thue, i * 2);
            for (int j = 0; j < i; j++) {
                if (thue[j] == 0) {
                    thue[j + i] = 1;
                }
                else {
                    thue[j + i] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thue[i] == thue[j]) {
                    System.out.print("+" + "  ");
                }
                else {
                    System.out.print("-" + "  ");
                }
                if (j == n - 1) {
                    System.out.println();
                }
            }
        }
        return;
    }
}
