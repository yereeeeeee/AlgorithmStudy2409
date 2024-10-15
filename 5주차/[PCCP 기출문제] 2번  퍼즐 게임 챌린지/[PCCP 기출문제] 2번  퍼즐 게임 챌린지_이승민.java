import java.util.*;
class Solution {
    static int n;
    static long limit;
    static int[] times;
    static int[] diffs;
    public int solution(int[] ds, int[] ts, long l) {
        n = ts.length;
        limit = l;
        times = ts;
        diffs = ds;
        int start = 1;
        int end = 100000;
        
        int mid = (start + end) / 2;
        while(start < end) {
            mid = (start + end) / 2;
            long tempTime = solve(mid);
            if (tempTime < limit) {
                end = mid;
            } else if (tempTime > limit) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
    static long solve (int level) {
        long totalTime  = 0;

        for (int i = 0; i < diffs.length; i++) {
            int solveTimes = diffs[i] - level;

            if (solveTimes <= 0) {
                totalTime += times[i];
                continue;
            }

            if (i == 0) {
                totalTime += (long) times[i] * solveTimes + times[i];
            } else {
                totalTime += (long) (times[i - 1] + times[i]) * solveTimes + times[i];
            }
        }
        return totalTime;
    }
}