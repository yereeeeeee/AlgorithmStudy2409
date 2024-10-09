import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        int[][] rec = new int[101][101];

        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int x = x1; x <= x2; x++) {
                if (rec[y1][x] != -1) rec[y1][x] = 1;
                if (rec[y2][x] != -1) rec[y2][x] = 1;
            }
            for (int y = y1; y <= y2; y++) {
                if (rec[y][x1] != -1) rec[y][x1] = 1;
                if (rec[y][x2] != -1) rec[y][x2] = 1;
            }

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    rec[y][x] = -1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2});
        rec[characterY * 2][characterX * 2] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == itemX * 2 && nowY == itemY * 2) {
                return rec[nowY][nowX] / 2;
            }

            for(int d = 0; d < 4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if (nextX >= 1 && nextX <= 100 && nextY >= 1 && nextY <= 100 && rec[nextY][nextX] == 1) {
                    q.add(new int[]{nextX, nextY});
                    rec[nextY][nextX] = rec[nowY][nowX] + 1;
                }
            }
        }

        return rec[itemY][itemX] / 2;
    }
}
