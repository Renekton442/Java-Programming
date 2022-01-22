/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int step = 0;
        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
            step++;
        }
        System.out.println("steps = " + step);
        return;
    }
}
