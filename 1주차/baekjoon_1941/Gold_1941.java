package gold;
import java.util.*;
import java.io.*;

public class Gold_1941 {
    static boolean[][] board = new boolean[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int ans = 0;
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (line.charAt(j) == 'S') board[i][j] = true;
            }
        }

        comb(0, 0, 0, 0);
        System.out.println(ans);
    }

    static void comb(int yCnt, int sCnt, int startY, int startX) {
        if (sCnt + yCnt == 7) {
            if (sCnt >= 4 && check()) {
                ans++;
            }
            return;
        }
        if (yCnt >= 4) {
            return;
        }

        for (int i = startY; i < 5; i++) {
            for (int j = ((startY == i) ? startX : 0); j < 5; j++) {
                visited[i][j] = true;
                comb(yCnt + (board[i][j] ? 0 : 1), sCnt + (board[i][j] ? 1 : 0), i, j + 1);
                visited[i][j] = false;
            }
        }
    }

    static boolean check() {
        int cnt = 0;
        boolean[][] checkVisited = new boolean[5][5];
        Queue<int[]> q = startQ(checkVisited);

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            cnt++;
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
                    if (visited[ni][nj] && !checkVisited[ni][nj]) {
                        q.add(new int[]{ni, nj});
                        checkVisited[ni][nj] = true;
                    }
                }
            }
        }
        return cnt == 7;
    }

    static Queue<int[]> startQ(boolean[][] checkVisited) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j] == true) {
                    q.add(new int[]{i, j});
                    checkVisited[i][j] = true;
                    return q;
                }
            }
        }

        return q;
    }
}
