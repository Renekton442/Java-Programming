/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {
    private static void towerOfHanoi(int n, char fromRod,
                                     char toRod, char auxRod1,
                                     char auxRod2) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disk " + n +
                                       " from rod " + fromRod +
                                       " to rod " + toRod);
            return;
        }

        towerOfHanoi(n - 2, fromRod, auxRod1, auxRod2,
                     toRod);
        System.out.println("Move disk " + (n - 1) +
                                   " from rod " + fromRod +
                                   " to rod " + auxRod2);
        System.out.println("Move disk " + n +
                                   " from rod " + fromRod +
                                   " to rod " + toRod);
        System.out.println("Move disk " + (n - 1) +
                                   " from rod " + auxRod2 +
                                   " to rod " + toRod);
        towerOfHanoi(n - 2, auxRod1, toRod, fromRod,
                     auxRod2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        towerOfHanoi(n, 'A', 'D', 'B', 'C');
    }
}
