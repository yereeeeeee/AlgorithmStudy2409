import java.util.*;

class Solution {
    static int num = 1;
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};
    static int[][] land;
    static int n;
    static int m;
    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int[][] land) {
        Solution.land = land;
        int answer = 0;
        n = land.length;
        m = land[0].length;


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1){
                    num++;
                    area(i, j, num);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < m; i++) {
            boolean[] visited = new boolean[num + 1];
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(land[j][i] != 0 && !visited[land[j][i]]) {
                    visited[land[j][i]] = true;
                    cnt += map.get(land[j][i]);
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }


    static void area(int i, int j, int num) {
        Queue<int[]> q = new LinkedList<>();
        land[i][j] = num;
        int cnt = 1;
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int k = 0; k < 4; k++) {
                int ni = now[0] + di[k];
                int nj = now[1] + dj[k];
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && land[ni][nj] == 1) {
                    q.add(new int[]{ni, nj});
                    land[ni][nj] = num;
                    cnt++;
                }
            }
        }
        map.put(num, cnt);
    }
}
