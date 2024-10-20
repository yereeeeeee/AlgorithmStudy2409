package gold;

import java.io.*;

public class Gold_9207 {
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};
    static int cnt;
    static int pin;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            cnt = Integer.MAX_VALUE;
            pin = 0;
            char[][] board = new char[5][9];
            for (int j = 0; j < 5; j++) {
                board[j] = br.readLine().toCharArray();
                for (int k = 0; k < 9; k++) {
                    if (board[j][k] == 'o') {
                        pin++;
                    }
                }
            }
            min = pin;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 9; k++) {
                    if (board[j][k] == 'o') {
                        move(board, j, k, pin, 0);
                    }
                }
            }
            sb.append(min + " " + cnt + "\n");
            br.readLine(); // 다음 보드 입력 받기 전 빈 줄 처리
        }
        System.out.println(sb);
    }

    static void move(char[][] board, int i, int j, int pin, int tempCnt) {
        if (pin <= min) {
            min = pin;
            cnt = tempCnt;
        }

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (canMove(ni, nj) && board[ni][nj] == 'o') {
                int nni = ni + di[k];
                int nnj = nj + dj[k];
                if (canMove(nni, nnj) && board[nni][nnj] == '.') {
                    board[i][j] = '.';
                    board[ni][nj] = '.';
                    board[nni][nnj] = 'o';
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 9; m++) {
                            if (board[l][m] == 'o') {
                                move(board, l, m, pin - 1, tempCnt + 1);
                            }
                        }
                    }
                    board[i][j] = 'o';
                    board[ni][nj] = 'o';
                    board[nni][nnj] = '.';
                }
            }
        }
    }

    static boolean canMove(int i, int j) {
        return i >= 0 && i < 5 && j >= 0 && j < 9;
    }
}
