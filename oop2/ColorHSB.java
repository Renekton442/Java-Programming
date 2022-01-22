/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {
    private final int h, s, b;

    public ColorHSB(int h, int s, int b) {
        this.h = h;
        this.s = s;
        this.b = b;
    }

    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    public boolean isGrayscale() {
        return (s == 0 || b == 0);
    }

    public int distanceSquaredTo(ColorHSB that) {
        int dh1 = this.h - that.h;
        int dh2 = 360 - Math.abs(dh1);
        int ds = this.s - that.s;
        int db = this.b - that.b;
        return Math.min(dh1 * dh1, dh2 * dh2) + ds * ds + db * db;
    }

    public static void main(String[] args) {
        int h0 = Integer.parseInt(args[0]);
        int s0 = Integer.parseInt(args[1]);
        int b0 = Integer.parseInt(args[2]);
        ColorHSB color0 = new ColorHSB(h0, s0, b0);

        String closestName = null;
        int closestDistance = Integer.MAX_VALUE;
        ColorHSB closestColor = null;

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB color = new ColorHSB(h, s, b);

            int distance = color0.distanceSquaredTo(color);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestName = name;
                closestColor = color;
            }
        }
        StdOut.println(closestName + " " + closestColor.toString());
    }
}
