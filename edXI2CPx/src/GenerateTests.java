import mooc.EdxIO;

import java.util.Arrays;

public class GenerateTests {


    public static void seiveOfEratosthenes(boolean[] primes) {

        int n = primes.length;

        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                int k = 2;
                int j = i * k;
                for (; j < n; k++) {
                    primes[j] = false;
                    j = i * k;
                }
            }
        }

    }


    public static void main(String[] args) {

        try(EdxIO io = EdxIO.create()) {

            int k = io.nextInt();

            boolean[] primes = new boolean[k+1];

            seiveOfEratosthenes(primes);

//            for(int i = 0; i < primes.length; i++) {
//                if(primes[i]) {
//                    io.println(i);
//                }
//            }



        }

    }

}
