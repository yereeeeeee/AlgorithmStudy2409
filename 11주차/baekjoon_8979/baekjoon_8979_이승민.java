package Silver;

import java.io.*;
import java.util.*;

public class Silver_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] scores = new long[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            long sum = (long) Integer.parseInt(st.nextToken()) * 1_000_000_000_000L // 1조 가중치
                    + (long) Integer.parseInt(st.nextToken()) * 1_000_000L       // 100만 가중치
                    + Integer.parseInt(st.nextToken());                         // 1 가중치
            scores[team] = sum;
        }
        int rank = 1;
        for (int i = 1; i <= n; i++) {
            if (scores[i] > scores[k]) rank++;
        }
        System.out.println(rank);
    }
}

