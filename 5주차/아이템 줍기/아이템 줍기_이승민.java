import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        int[][] rec = new int[102][102]; // 좌표 2배로 확장

        // 2배로 확장하여 그리기 (정확한 경계선을 구분하기 위함)
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            // 경계선 그리기
            for (int x = x1; x <= x2; x++) {
                if (rec[y1][x] != -1) rec[y1][x] = 1; // 위쪽 경계선
                if (rec[y2][x] != -1) rec[y2][x] = 1; // 아래쪽 경계선
            }
            for (int y = y1; y <= y2; y++) {
                if (rec[y][x1] != -1) rec[y][x1] = 1; // 왼쪽 경계선
                if (rec[y][x2] != -1) rec[y][x2] = 1; // 오른쪽 경계선
            }

            // 내부를 -1로 표시
            for (int y = y1 + 1;
            y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    rec[y][x] = -1;
                }
            }
        }

        // BFS 탐색
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2, 0}); // 시작점도 2배로 변환
        rec[characterY * 2][characterX * 2] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int t = now[2];

            if (nowX == itemX * 2 && nowY == itemY * 2) {
                return t / 2; // 결과를 다시 절반으로 나누어 반환
            }

            for(int d = 0; d < 4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if (nextX >= 1 && nextX <= 100 && nextY >= 1 && nextY <= 100 && rec[nextY][nextX] == 1) {
                    q.add(new int[]{nextX, nextY, t+1});
                    rec[nextY][nextX] = 0; // 방문한 경로는 0으로 표시하여 다시 방문하지 않게 함
                }
            }
        }

        return -1;
    }
}
