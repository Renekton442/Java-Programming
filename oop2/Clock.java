/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private int hours;
    private int minutes;

    private static final int HOURSPERDAY = 24;
    private static final int MINUTESPERHOUR = 60;

    public Clock(int h, int m) {
        hours = h;
        minutes = m;
    }

    public Clock(String s) {
        if (!s.matches("[0-9][0-9]:[0-9][0-9]")) {
            throw new IllegalArgumentException("invalid time: " + s);
        }
        hours = Integer.parseInt(s.substring(0, 2));
        minutes = Integer.parseInt(s.substring(3, 5));
    }

    private static void validateTime(int h, int m) {
        if (h < 0 || h >= HOURSPERDAY) {
            throw new IllegalArgumentException("hours is invalid: " + h);
        }
        if (m < 0 || m >= MINUTESPERHOUR) {
            throw new IllegalArgumentException("minutes is invalid: " + m);
        }
    }

    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) return true;
        if (this.hours > that.hours) return false;
        return this.minutes < that.minutes;
    }

    public void tic() {
        minutes++;
        if (minutes == MINUTESPERHOUR) {
            minutes = 0;
            hours++;
        }
        if (hours == HOURSPERDAY) {
            hours = 0;
        }
    }

    public void toc(int delta) {
        int num = delta / 60;
        int res = delta % 60;
        minutes += res;
        hours += num;
        if (minutes >= MINUTESPERHOUR) {
            minutes -= MINUTESPERHOUR;
            hours++;
        }
        if (hours >= HOURSPERDAY) {
            hours -= HOURSPERDAY;
        }
    }

    public static void main(String[] args) {
        Clock start = new Clock(args[0]);
        Clock stop = new Clock(args[1]);
        int delta = Integer.parseInt(args[2]);
        for (Clock x = start; x.isEarlierThan(stop); x.tic()) {
            StdOut.println(x);
        }
        Clock y = start;
        y.toc(delta);
        StdOut.println(y);
    }
}
