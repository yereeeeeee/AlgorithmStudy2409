import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height <= height) {
                stack.pop(); // 현재 타워보다 낮은 타워 제거
            }

            if (stack.isEmpty()) {
                answer.append("0 "); // 왼쪽에 더 높은 타워가 없으면 0 추가
            } else {
                answer.append(stack.peek().num).append(" "); // 가장 가까운 높은 타워 번호 추가
            }

            stack.push(new Tower(i, height)); // 현재 타워 추가
        }

        bw.write(answer.toString().trim()); // 마지막 공백 제거 후 출력
        bw.flush();
        bw.close();
        br.close();
    }

    static class Tower {
        int num;
        int height;

        public Tower(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}
