/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int step = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                double random = Math.random();
                if (random <= 0.25) {
                    x++;
                }
                else if (random <= 0.5) {
                    y--;
                }
                else if (random <= 0.75) {
                    x--;
                }
                else if (random <= 1.0) {
                    y++;
                }
                step++;
            }
        }
        System.out.print("average number of steps = " + (double) step / trials);
        return;
    }
}
