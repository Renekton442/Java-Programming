/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (k < 0)
            k = -k;
        if (n == 0 && k == 0)
            return 1;
        if (k < -n || k > n)
            return 0;
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][Math.abs(j - 1)] + dp[i - 1][j] + dp[i - 1][j + 1];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
