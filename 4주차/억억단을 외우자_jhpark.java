import java.util.*;
import java.io.*;

class Solution {
    static int arr[];
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        // 1부터 e까지 돌며 각 숫자의 배수들을 arr에 +1 해줌
        arr = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                arr[j] += 1;
            }
        }

        // maxNum[i]: i부터 e까지 가장 많이 등장한 숫자를 저장하는 배열
        int[] maxNum = new int[e + 1];
        maxNum[e] = e;  // 마지막 값은 자기 자신
        for (int i = e - 1; i >= 1; i--) {
            // 현재 값이 다음 값보다 등장 횟수가 많거나 같으면 현재 값 선택
            if (arr[i] >= arr[maxNum[i + 1]]) {
                maxNum[i] = i;
            } else {
                maxNum[i] = maxNum[i + 1];
            }
        }

        // 각 starts 값에 대한 결과 계산
        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxNum[starts[i]];
        }

        return answer;
    }
}
