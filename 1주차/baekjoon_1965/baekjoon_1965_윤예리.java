import java.io.*;
import java.util.*;

public class baekjoon_1965_윤예리 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int answer = 1;
        // 돌면서 dp 값 넣어주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    answer = Math.max(dp[i], answer);
                }
            }
        }

        System.out.println(answer);
    }
}
