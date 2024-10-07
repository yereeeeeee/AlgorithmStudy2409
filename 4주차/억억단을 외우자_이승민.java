import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int len = starts.length;
        int[] answer = new int[len];
        int[] cnt = new int[e + 1];
        int[] maxCnt = new int[e + 1];
        for(int i = 1; i <= e; i++) {
            cnt[i] = 1;
        }
        for(int i = 2; i <= e; i++) {
            for(int j = 1; j < e; j++) {
                if(i * j > e) break;
                cnt[i * j]++;
            }
        }
        // cnt[1] = 1;
        // cnt[2] = 2;
        // cnt[3] = 2;
        // for(int i = 4; i <= e; i++) {
        //     int temp = 0;
        //     for(int j = 1; j < Math.sqrt(i); j++) {
        //         if(i % j == 0) {
        //             temp++;
        //         }
        //     }
        //     cnt[i] = temp * 2;
        //     if(i % Math.sqrt(i) == 0) {
        //         cnt[i]++;
        //     }
        // }
        int minIdx = e;
        int maxNum = cnt[e];
        for(int i = e; i > 0; i--) {
            if(maxNum <= cnt[i]) {
                maxNum = cnt[i];
                minIdx = i;
            }
            maxCnt[i] = minIdx;
        }
        for(int i = 0; i < len; i++){
            answer[i] = maxCnt[starts[i]];
        }
        return answer;
    }
}