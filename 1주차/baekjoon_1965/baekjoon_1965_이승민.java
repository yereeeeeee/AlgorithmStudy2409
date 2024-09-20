package Silver;
import java.util.*;
import java.io.*;

public class Silver_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        box.add(Integer.parseInt(st.nextToken()));
        int end = box.get(0);
        int boxSize = 1;
        for (int i = 1; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < end) {
                int left = 0;
                int right = box.size() - 1;
                while (left < right) {
                    int mid = (right + left) / 2;
                    if (box.get(mid) < temp) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                box.set(right, temp);
            } else if (temp > end) {
                box.add(temp);
                boxSize++;
            }
            end = box.get(boxSize - 1);
        }
        System.out.println(box.size());
    }
}
