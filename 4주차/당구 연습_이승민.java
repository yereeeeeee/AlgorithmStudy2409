import java.util.*;

class Solution {
    public int[] solution(int m, int n, int x, int y, int[][] balls) {
        int len = balls.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            int nx = balls[i][0];
            int ny = balls[i][1];
            
            int min = Integer.MAX_VALUE;
            
            // 상
            if (!(x == nx && y < ny)) {
                min = Math.min(min, (int)(Math.pow(x - nx, 2) + Math.pow((2 * n - y - ny), 2)));
            }
            
            // 하
            if (!(x == nx && y > ny)) {
                min = Math.min(min, (int)(Math.pow(x - nx, 2) + Math.pow(y + ny, 2)));
            }
            
            // 좌
            if (!(y == ny && x > nx)) {
                min = Math.min(min, (int)(Math.pow(x + nx, 2) + Math.pow(y - ny, 2)));
            }
            
            // 우
            if (!(y == ny && x < nx)) {
                min = Math.min(min, (int)(Math.pow((2 * m - x - nx), 2) + Math.pow(y - ny, 2)));
            }
            
            res[i] = min;
        }

        return res;
    }
}
