/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int num = a;
            a = b;
            b = num % b;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (Math.abs(a) * Math.abs(b) / Divisors.gcd(a, b));
    }

    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1)
            return true;
        else
            return false;
    }

    public static int totient(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Divisors.areRelativelyPrime(i, n))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd" + "(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm" + "(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println(
                "areRelativelyPrime" + "(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient" + "(" + a + ") = " + totient(a));
        System.out.println("totient" + "(" + b + ") = " + totient(b));
        return;
    }
}
