/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.print((!(a <= 0 || b <= 0 || c <= 0) && (a * a + b * b == c * c
                || b * b + c * c == a * a
                || a * a + c * c == b * b)));
        return;
    }
}
