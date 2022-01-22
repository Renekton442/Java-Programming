/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 1];
        for (int i = 0; i < trials; i++) {
            boolean[] hasBirthday = new boolean[n];
            int people = 0;
            while (true) {
                people++;
                int d = (int) (Math.random() * (n - 1));
                if (hasBirthday[d] == true) {
                    count[people]++;
                    break;
                }
                hasBirthday[d] = true;
            }
        }
        double[] frac = new double[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += count[i];
            frac[i] = (double) sum / trials;
            System.out.println(i + "   " + count[i] + "   " + frac[i]);
            if (frac[i] > 0.50)
                break;
        }
        return;
    }
}
