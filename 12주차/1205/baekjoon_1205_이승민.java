package Silver;
import java.io.*;
import java.util.*;

public class Silver_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 점수 개수
        int t = Integer.parseInt(st.nextToken()); // 태수 점수
        int p = Integer.parseInt(st.nextToken()); // 올라갈 점수
        if (n == 0) {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());

        int rank = 1;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            int tempScore = Integer.parseInt(st.nextToken());
            if (tempScore > t) {
                rank++;
                cnt++;
            } else if (tempScore == t) {
                cnt++;
            }
            if (cnt > p) {
                rank = -1;
                break;
            }
        }
        System.out.println(rank);
    }
}
