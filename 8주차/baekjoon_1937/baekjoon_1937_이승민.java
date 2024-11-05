package gold;

import java.io.*;
import java.util.*;

public class Gold_1937 {
    static int n;
    static int cnt;
    static int[][] bamboo;
    static int[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bamboo = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                bamboo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = Math.max(cnt, dfs(i, j));
            }
        }
        System.out.println(cnt);
    }

    static int dfs(int i, int j) {
        if (visited[i][j] != 0) return visited[i][j];

        visited[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (range(ni, nj) && bamboo[i][j] < bamboo[ni][nj]) {
                visited[i][j] = Math.max(visited[i][j], dfs(ni, nj) + 1);
            }
        }
        return visited[i][j];
    }

    static boolean range(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
