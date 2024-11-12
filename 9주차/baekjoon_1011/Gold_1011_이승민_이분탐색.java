package gold;

import java.io.*;
import java.util.*;

public class Gold_1011_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dis = y - x;

            int cur = 0;
            int vel = 1;
            int t = 0;
            while (cur < dis) {
                if (t % 2 == 0) {
                    cur += vel;
                } else {
                    cur += vel;
                    vel += 1;
                }
                t++;
            }
            System.out.println(t);
        }
    }
}
