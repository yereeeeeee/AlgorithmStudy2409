package gold;

import java.io.*;
import java.util.*;

public class Gold_2879 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int preDiff = Integer.parseInt(st2.nextToken()) - Integer.parseInt(st1.nextToken());
        int cnt = Math.abs(preDiff);

        for (int i = 1; i < n; i++) {
            int tap = Integer.parseInt(st1.nextToken());
            int toBe = Integer.parseInt(st2.nextToken());

            int curDiff = toBe - tap;
            int absPreDiff = Math.abs(preDiff);
            int absCurDiff = Math.abs(curDiff);

            if (preDiff * curDiff >= 0) {
                cnt += absCurDiff > absPreDiff ? (absCurDiff - absPreDiff) : 0;
            } else {
                cnt += absCurDiff;
            }

            preDiff = curDiff;
        }
        System.out.println(cnt);
    }


}
