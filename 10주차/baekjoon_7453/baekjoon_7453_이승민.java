package gold;
import java.util.*;
import java.io.*;

public class Gold_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] abcd = new int[4][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                abcd[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {
            Arrays.sort(abcd[i]);
        }

        int[] ab = new int[n * n];
        int[] cd = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = abcd[0][i] + abcd[1][j];
                cd[idx++] = abcd[2][i] + abcd[3][j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int abIdx = 0;
        int cdIdx = n * n - 1;
        long cnt = 0;
        while (abIdx < n * n && cdIdx >= 0) {
            int nowAb = ab[abIdx];
            int nowCd = cd[cdIdx];
            int sum = nowAb + nowCd;
            if (sum > 0) {
                cdIdx--;
            } else if (sum < 0) {
                abIdx++;
            } else {
                long abCnt = 0;
                long cdCnt = 0;
                while (abIdx < n * n && ab[abIdx] == nowAb) {
                    abIdx++;
                    abCnt++;
                }
                while (cdIdx >= 0 && cd[cdIdx] == nowCd) {
                    cdIdx--;
                    cdCnt++;
                }
                cnt += abCnt * cdCnt;
            }
        }
        System.out.println(cnt);
    }
}