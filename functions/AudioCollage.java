/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < newSound.length; i++) {
            newSound[i] = a[i] * alpha;
        }
        return newSound;
    }

    public static double[] reverse(double[] a) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < newSound.length; i++) {
            newSound[i] = a[a.length - 1 - i];
        }
        return newSound;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] newSound = Arrays.copyOf(a, a.length + b.length);
        for (int i = 0; i < b.length; i++) {
            newSound[a.length + i] = b[i];
        }
        return newSound;
    }

    public static double[] mix(double[] a, double[] b) {
        double[] newSound;
        if (a.length >= b.length) {
            newSound = Arrays.copyOf(b, a.length);
            for (int i = 0; i < a.length; i++) {
                newSound[i] += a[i];
            }
        }
        else {
            newSound = Arrays.copyOf(a, b.length);
            for (int i = 0; i < b.length; i++) {
                newSound[i] += b[i];
            }
        }
        return newSound;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        double[] newSound = new double[(int) (n / alpha)];
        for (int i = 0; i < (int) (n / alpha); i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }

    public static void main(String[] args) {
        double[] a = StdAudio.read("beatbox.wav");
        double[] b = StdAudio.read("chimes.wav");
        double[] c = StdAudio.read("dialup.wav");
        double[] d = StdAudio.read("harp.wav");
        double[] e = StdAudio.read("piano.wav");
        StdAudio.play(amplify(a, 0.5));
        StdAudio.play(reverse(b));
        StdAudio.play(merge(a, b));
        StdAudio.play(mix(c, d));
        StdAudio.play(changeSpeed(e, 1.5));
        StdAudio.close();
    }
}
