package gold;

import java.util.*;
import java.io.*;

public class Gold_15683 {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int cctv;
    static List<int[]> cctvList = new ArrayList<>();
    static int[][] office;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] != 6) {
                    cctvList.add(new int[]{i, j});
                    cctv++;
                }

            }
        }

        nextCctv(0);
//        System.out.println("OFFICE");
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(office[i]));
//        }
        System.out.println(min);
    }

    static List<int[]> detect(int i, int j, int d) {
        List<int[]> visited = new ArrayList<>();
        // 상
        if (d == 0) {
            for (int k = i - 1; k >= 0; k--) {
                if (office[k][j] == 0) {
                    office[k][j] = -1;
                    visited.add(new int[]{k, j});
                } else if (office[k][j] == 6) {
                    break;
                }
            }

        }
        // 하
        else if (d == 1) {
            for (int k = i + 1; k < n; k++) {
                if (office[k][j] == 0) {
                    office[k][j] = -1;
                    visited.add(new int[]{k, j});
                } else if (office[k][j] == 6) {
                    break;
                }
            }

        }
        // 좌
        else if (d == 2) {
            for (int k = j - 1; k >= 0; k--) {
                if (office[i][k] == 0) {
                    office[i][k] = -1;
                    visited.add(new int[]{i, k});
                } else if (office[i][k] == 6) {
                    break;
                }
            }
        }
        // 우
        else {
            for (int k = j + 1; k < m; k++) {
                if (office[i][k] == 0) {
                    office[i][k] = -1;
                    visited.add(new int[]{i, k});
                } else if (office[i][k] == 6) {
                    break;
                }
            }
        }
        return visited;
    }

    static void miss(List<int[]> visited) {
        for (int[] cur : visited) {
            office[cur[0]][cur[1]] = 0;
        }
    }

    static void nextCctv(int cctvCnt) {
        if (cctvCnt == cctv) {
            count();
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(office[i]));
//            }
//            System.out.println();
            return;
        }

        int[] cur = cctvList.get(cctvCnt);
        int type = office[cur[0]][cur[1]];
        int curI = cur[0];
        int curJ = cur[1];
        if (type == 1) {
            for (int i = 0; i < 4; i++) {
                List<int[]> detect = detect(curI, curJ, i);
                nextCctv(cctvCnt + 1);
                miss(detect);
            }
        } else if (type == 2) {
            for (int i = 0; i < 3; i += 2) {
                List<int[]> detect = detect(curI, curJ, i);
                detect.addAll(detect(curI, curJ, i + 1));
                nextCctv(cctvCnt + 1);
                miss(detect);
            }
        } else if (type == 3) {
            for (int i = 0; i < 2; i++) {
                for (int j = 2; j <= 3; j++) {
                    List<int[]> detect = detect(curI, curJ, i);
                    detect.addAll(detect(curI, curJ, j));
                    nextCctv(cctvCnt + 1);
                    miss(detect);
                }
            }
        } else if (type == 4) {
            for (int i = 0; i < 4; i++) {
                List<int[]> detect = detect(curI, curJ, i);
                detect.addAll(detect(curI, curJ, (i + 1) % 4));
                detect.addAll(detect(curI, curJ, (i + 2) % 4));
                nextCctv(cctvCnt + 1);
                miss(detect);
            }
        } else if (type == 5) {
            for (int i = 0; i < 4; i++) {
                detect(curI, curJ, i);
            }
            nextCctv(cctvCnt + 1);
        }
    }

    static void count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 0) {
                    cnt++;
                }
            }
        }
//        if (min > cnt) {
//            System.out.println("cnt = " + cnt);
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(office[i]));
//            }
//            System.out.println();
//        }
        min = Math.min(min, cnt);
    }
}
