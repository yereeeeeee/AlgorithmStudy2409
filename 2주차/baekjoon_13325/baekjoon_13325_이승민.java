package gold;

import java.util.*;
import java.io.*;

public class Gold_13325 {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] nodes = new int[(int) Math.pow(2, k + 1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < Math.pow(2, k + 1); i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = (int) (Math.pow(2, k + 1) - 1); i > 1; i -= 2) {
            int right = nodes[i];
            int left = nodes[i - 1];
            sum += Math.min(right, left) + Math.abs(right - left);
            nodes[i / 2] += Math.max(right, left);
        }
        System.out.println(sum + nodes[1]);
    }
}
