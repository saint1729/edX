import mooc.EdxIO;

import java.util.Arrays;

public class WinCompetition {

    private static final int TOTAL_TIME = 300 * 60;

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }

            Arrays.sort(a);

            int ans = 0, sum = 0;

            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (sum > TOTAL_TIME) {
                    break;
                }
                ans += 1;
            }

            io.println(ans);

        }

    }

}
