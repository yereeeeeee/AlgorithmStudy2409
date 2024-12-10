package Silver;

import java.io.*;
import java.util.*;

public class Silver_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            int tc = Integer.parseInt(input[0]);
            int[] heights = new int[20];

            for (int i = 0; i < 20; i++) {
                heights[i] = Integer.parseInt(input[i + 1]);
            }

            int moves = 0;
            ArrayList<Integer> sortedList = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                int height = heights[i];
                int pos = binary(sortedList, height);
                sortedList.add(pos, height);
                moves += sortedList.size() - 1 - pos;
            }

            sb.append(tc).append(" ").append(moves).append("\n");
        }

        System.out.print(sb);
    }

    private static int binary(ArrayList<Integer> list, int height) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < height) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
