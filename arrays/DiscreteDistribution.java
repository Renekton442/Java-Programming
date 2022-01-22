/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + Integer.parseInt(args[i]);
        }
        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * s[n]);
            for (int k = 1; k <= n; k++) {
                if (r >= s[k - 1] && r < s[k]) {
                    System.out.print(k + " ");
                    break;
                }
            }
        }
        return;
    }
}
