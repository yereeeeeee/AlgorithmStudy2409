package gold;

import java.io.*;
import java.util.*;

public class Gold_16933 {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0, true));
        dp[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;
            int broken = node.broken;
            boolean isDay = node.isDay;

            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (range(nx, ny)) {
                    if (map[nx][ny] == 1 && broken < k) {
                        if (isDay && dp[nx][ny][broken + 1] == 0) {
                            dp[nx][ny][broken + 1] = distance + 1;
                            queue.add(new Node(nx, ny, distance + 1, broken + 1, !isDay));
                        } else if (!isDay) {
                            queue.add(new Node(x, y, distance + 1, broken, !isDay));
                        }
                    } else if (map[nx][ny] == 0 && dp[nx][ny][broken] == 0) {
                        dp[nx][ny][broken] = distance + 1;
                        queue.add(new Node(nx, ny, distance + 1, broken, !isDay));
                    }
                }
            }
        }
        return -1;
    }

    static boolean range(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Node {
        int x, y, distance, broken;
        boolean isDay;

        public Node(int x, int y, int distance, int broken, boolean isDay) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
            this.isDay = isDay;
        }
    }
}
