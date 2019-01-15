import mooc.EdxIO;

public class PrepareYourselfCompetitions {

    private static int compare(int[] a, int[] b, int n) {

        int a0 = a[0];
        int b0 = b[0];

        int c = (a0 < b0) ? -1 : 1;

        for(int i = 1; i < n; i++) {
            if(((c == -1) && (a[i] > b[i])) || ((c == 1) && (a[i] < b[i]))) {
                return 0;
            }
        }

        return c;
    }

    private static int maxIndex(int[] a, int n) {
        int index = 0;
        for(int i = 1; i < n; i++) {
            if(a[i] > a[index]) {
                index = i;
            }
        }
        return index;
    }

    private static int maxAbsDiffIndex(int[] a, int[] b, int n) {
        int index = 0;
        for(int i = 1; i < n; i++) {
            if (Math.abs(a[i] - b[i]) > Math.abs(a[index] - b[index])) {
                index = i;
            }
        }
        return index;
    }

    private static int minAbsDiffIndex(int[] a, int[] b, int n) {
        int index = 0;
        for(int i = 1; i < n; i++) {
            if (Math.abs(a[i] - b[i]) < Math.abs(a[index] - b[index])) {
                index = i;
            }
        }
        return index;
    }


    private static int sum(int[] a) {
        int ans = 0;
        for(int x : a) {
            ans += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        try(EdxIO io = EdxIO.create()) {
            int n = io.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            for(int i = 0; i < n; i++) {
                b[i] = io.nextInt();
            }

            int c = compare(a, b, n);

            if((c == -1) || (c == 1)) {
                int index = minAbsDiffIndex(a, b, n);
                io.println(sum((c == -1) ? b : a)-Math.abs(a[index]-b[index]));
            } else {
                int ans = 0;
                for(int i = 0; i < n; i++) {
                    ans += Math.max(a[i], b[i]);
                }
                io.println(ans);
            }
        }
    }

}
