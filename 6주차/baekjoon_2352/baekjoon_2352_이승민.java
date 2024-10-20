package gold;

import java.util.*;
import java.io.*;

public class Gold_2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        int len = 0;
        arr.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int before = arr.get(len);
            if (before < now) {
                arr.add(now);
                len++;
            } else {
                binary(arr, len, now);
            }
        }
        System.out.println(len + 1);
    }

    static void binary(List<Integer> arr, int len, int now) {
        int start = 0;
        int end = len;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr.get(mid) < now) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        arr.set(end, now);
    }
}
