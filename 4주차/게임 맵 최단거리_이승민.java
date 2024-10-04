import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] di = new int[]{-1, 1, 0, 0};
        int[] dj = new int[]{0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n-1, m-1});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int ni = now[0] + di[i];
                int nj = now[1] + dj[i];
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && maps[ni][nj] == 1) {
                    q.add(new int[]{ni, nj});
                    maps[ni][nj] += maps[now[0]][now[1]];
                    if(ni == 0 && nj == 0) {
                        return maps[ni][nj];
                    }
                }
            }
        }
        return -1;
    }
}