package gold;

import java.io.*;
import java.util.*;

public class Gold_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] notPrimes = new boolean[n + 1];
        notPrimes[0] = true;
        notPrimes[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!notPrimes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    notPrimes[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        int size = 0;
        for (int i = 0; i <= n; i++) {
            if (!notPrimes[i]) {
                primes.add(i);
                size++;
            }
        }
        int cnt = 0;

//        for (int i = size - 1; i >= 0; i--) {
//            int sum = 0;
//            for (int j = i; j >= 0; j--) {
//                sum += primes.get(j);
//                if (sum > n) {
//                    break;
//                } else if (sum == n) {
//                    cnt++;
//                }
//            }
//        }

        int s = 0;
        int e = 0;
        int sum = 0;
        while (e < size) {
            if (sum < n) sum += primes.get(e++);

            if (sum > n) sum -= primes.get(s++);

            if (sum == n) {
                sum -= primes.get(s++);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}