/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] array = new String[m + 2][n + 2];
        int mines = k;
        while (mines > 0) {
            int a = (int) (Math.random() * m) + 1;
            int b = (int) (Math.random() * n) + 1;
            if (array[a][b] != "*") {
                array[a][b] = "*";
                mines--;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (array[i][j] != "*") {
                    int count = 0;
                    if (i - 1 >= 0 && j - 1 >= 0)
                        if (array[i - 1][j - 1] == "*")
                            count++;
                    if (i - 1 >= 0)
                        if (array[i - 1][j] == "*")
                            count++;
                    if (j - 1 >= 0)
                        if (array[i][j - 1] == "*")
                            count++;
                    if (i - 1 >= 0 && j + 1 <= n)
                        if (array[i - 1][j + 1] == "*")
                            count++;
                    if (j + 1 <= n)
                        if (array[i][j + 1] == "*")
                            count++;
                    if (i + 1 <= m && j + 1 <= n)
                        if (array[i + 1][j + 1] == "*")
                            count++;
                    if (i + 1 <= m)
                        if (array[i + 1][j] == "*")
                            count++;
                    if (i + 1 <= m && j - 1 >= 0)
                        if (array[i + 1][j - 1] == "*")
                            count++;
                    array[i][j] = Integer.toString(count);
                }
            }
        }
        for (int row = 1; row <= m; row++) {
            for (int column = 1; column <= n; column++) {
                System.out.print(array[row][column] + "  ");
                if (column == n)
                    System.out.println();
            }
        }
        return;

    }
}

