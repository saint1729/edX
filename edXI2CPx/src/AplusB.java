import mooc.EdxIO;

public class AplusB {

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            io.println(io.nextInt() + io.nextInt());
        }
    }

}
