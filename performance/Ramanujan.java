/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {
    public static boolean isRamanujan(long n) {
        long i = 1;
        long j = (long) Math.cbrt(n);
        long sum = 0;
        int count = 0;
        while (i < j) {
            sum = i * i * i + j * j * j;
            if (sum < n) {
                i++;
            }
            else if (sum > n) {
                j--;
            }
            else
                count++;
            if (count == 2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
