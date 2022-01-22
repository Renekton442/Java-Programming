/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {
    public static double heaviside(double x) {
        if (x < 0)
            return 0;
        else if (x == 0)
            return 0.5;
        else
            return 1.0;
    }

    public static double sigmoid(double x) {
        return (1 / (1 + Math.exp(-x)));
    }

    public static double tanh(double x) {
        return ((Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)));
    }

    public static double softsign(double x) {
        return (x / (1 + Math.abs(x)));
    }

    public static double sqnl(double x) {
        if (x <= -2)
            return (-1.0);
        else if (x > -2 && x < 0)
            return (x + x * x / 4);
        else if (x >= 0 && x < 2)
            return (x - x * x / 4);
        else
            return 1.0;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside" + "(" + x + ")" + " = " + heaviside(x));
        System.out.println("sigmoid" + "(" + x + ")" + " = " + sigmoid(x));
        System.out.println("tanh" + "(" + x + ")" + " = " + tanh(x));
        System.out.println("softsign" + "(" + x + ")" + " = " + softsign(x));
        System.out.println("sqnl" + "(" + x + ")" + " = " + sqnl(x));
        return;
    }
}
