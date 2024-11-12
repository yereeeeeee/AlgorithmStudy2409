package gold;

import java.io.*;
import java.util.*;

public class Gold_1011_k {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int dis = y - x;

            System.out.println(minMoves(dis, k));
        }
    }

    static int minMoves(int dis, int k) {
        int max = (int) Math.sqrt(dis/k);

        if (k * max * max == dis) {
            return 2 * max - 1;
        } else if (k * max * max < dis && dis <= k * max * max + k * max) {
            return 2 * max;
        } else {
            return 2 * max + 1;
        }
    }
}
