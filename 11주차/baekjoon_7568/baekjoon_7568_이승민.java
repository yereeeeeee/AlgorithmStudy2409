import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람 수 입력
        int N = sc.nextInt();
        int[][] students = new int[N][2];

        // 학생 정보 입력
        for (int i = 0; i < N; i++) {
            students[i][0] = sc.nextInt(); // 몸무게
            students[i][1] = sc.nextInt(); // 키
        }

        // 등수 계산
        for (int i = 0; i < N; i++) {
            int rate = 1;
            for (int j = 0; j < N; j++) {
                if (students[i][0] < students[j][0] && students[i][1] < students[j][1]) {
                    rate++;
                }
            }
            System.out.print(rate + " ");
        }
    }
}
