package gold;

import java.io.*;
import java.util.*;

public class Gold_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dis = y - x;

            System.out.println(minMoves(dis));
        }
    }

    static int minMoves(int dis) {
        int max = (int) Math.sqrt(dis);

        if (max * max == dis) {
            return 2 * max - 1;
        } else if (max * max < dis && dis <= max * max + max) {
            return 2 * max;
        } else {
            return 2 * max + 1;
        }
    }
}
