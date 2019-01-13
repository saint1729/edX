import mooc.EdxIO;

public class AplusB2 {

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            long a = io.nextInt(), b = io.nextInt();
            long c = a+b*b;
            io.println(c);
        }
    }

}