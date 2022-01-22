/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            String str = dna.substring(i, i + 3);
            if (str.equals("CAG")) {
                count++;
                i += 3;
                if (count > max)
                    max = count;
            }
            else {
                count = 0;
                i++;
            }
        }
        return max;
    }

    public static String removeWhitespace(String s) {
        return s = s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9)
            return "not human";
        else if (maxRepeats >= 10 && maxRepeats <= 35)
            return "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39)
            return "high risk";
        else if (maxRepeats >= 40 && maxRepeats <= 180)
            return "Huntington's";
        else
            return "not human";
    }

    public static void main(String[] args) {
        In filename = new In(args[0]);
        String s = filename.readAll();
        String dna = removeWhitespace(s);
        int maxRepeats = maxRepeats(dna);
        StdOut.println(maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }
}
