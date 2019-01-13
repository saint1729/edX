import mooc.EdxIO;

public class Threebonacci {

    public static long f(long a, long b, long c, long n) {
        if(n == 0) {
            return a;
        } else if(n == 1) {
            return b;
        } else if(n == 2) {
            return c;
        } else {
            long d = a + b + -c;
            for (int i = 2; i < n; i++) {
                d = c + b - a;
                a = b;
                b = c;
                c = d;
            }
            return d;
        }
    }

    public static void main(String[] args) {
        try(EdxIO io = EdxIO.create()) {
            long a = io.nextLong();
            long b = io.nextLong();
            long c = io.nextLong();
            long n = io.nextLong();
                io.println(f(a, b, c, n));
        }
    }

}
