package Silver;

import java.io.*;

public class Silver_20125 {
    static int n;
    static int[] heart;
    static char[][] board;
    static StringBuilder sb = new StringBuilder();
    static int waistLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        boolean head = false;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
                if (!head && board[i][j] == '*') {
                    head = true;
                    heart = new int[]{i + 1, j};
                    sb.append((i + 2) + " " + (j + 1) + "\n");
                }
            }
        }

        calculateWaistLength();
        leftArm();
        rightArm();
        waist();
        leftLeg();
        rightLeg();

        System.out.print(sb);
    }

    static void leftArm() {
        int cnt = 0;
        for (int j = heart[1] - 1; j >= 0; j--) {
            if (board[heart[0]][j] == '*') cnt++;
            else break;
        }
        sb.append(cnt + " ");
    }

    static void rightArm() {
        int cnt = 0;
        for (int j = heart[1] + 1; j < n; j++) {
            if (board[heart[0]][j] == '*') cnt++;
            else break;
        }
        sb.append(cnt + " ");
    }

    static void waist() {
        sb.append(waistLength + " ");
    }

    static void leftLeg() {
        int cnt = 0;
        int legStart = heart[0] + waistLength + 1;
        for (int i = legStart; i < n; i++) {
            if (board[i][heart[1] - 1] == '*') cnt++;
            else break;
        }
        sb.append(cnt + " ");
    }

    static void rightLeg() {
        int cnt = 0;
        int legStart = heart[0] + waistLength + 1;
        for (int i = legStart; i < n; i++) {
            if (board[i][heart[1] + 1] == '*') cnt++;
            else break;
        }
        sb.append(cnt + "\n");
    }

    static void calculateWaistLength() {
        waistLength = 0;
        for (int i = heart[0] + 1; i < n; i++) {
            if (board[i][heart[1]] == '*') waistLength++;
            else break;
        }
    }
}

