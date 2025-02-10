import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }

        System.out.println(answer);
    }

    static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0));

        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        int maxDist = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            maxDist = Math.max(maxDist, cur.dist); // 최장 거리 갱신

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || arr[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                q.add(new Pos(nx, ny, cur.dist + 1));
            }
        }

        return maxDist;
    }

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}