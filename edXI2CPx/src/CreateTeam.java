import mooc.EdxIO;

public class CreateTeam {

    private static double distance(int a, int b, int c) {
        return Math.sqrt(a*a+b*b+c*c);
    }

    public static void main(String[] args) {
        int [][] a = new int[3][3];
        try(EdxIO io = EdxIO.create()) {
            a[0][0] = io.nextInt();
            a[0][1] = io.nextInt();
            a[0][2] = io.nextInt();
            a[1][0] = io.nextInt();
            a[1][1] = io.nextInt();
            a[1][2] = io.nextInt();
            a[2][0] = io.nextInt();
            a[2][1] = io.nextInt();
            a[2][2] = io.nextInt();
            double ans = Math.max(distance(a[0][0], a[1][1], a[2][2]), distance(a[0][0], a[1][2], a[2][1]));
            ans = Math.max(ans, distance(a[0][1], a[1][0], a[2][2]));
            ans = Math.max(ans, distance(a[0][1], a[1][2], a[2][0]));
            ans = Math.max(ans, distance(a[0][2], a[1][0], a[2][1]));
            ans = Math.max(ans, distance(a[0][2], a[1][1], a[2][0]));
            io.println(ans);
        }
    }

}
