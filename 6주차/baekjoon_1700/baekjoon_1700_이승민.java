package gold;
import java.io.*;
import java.util.*;

public class Gold_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] order = new int[k];

        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int unplug = 0;
        Set<Integer> plug = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int now = order[i];

            if (plug.size() < n) {
                plug.add(now);
                continue;
            }

            if (plug.contains(now)) {
                continue;
            }

            int farUse = -1;
            int unplugItem = -1;
            for (Integer item : plug) {
                int nextUse = Integer.MAX_VALUE;
                for (int j = i + 1; j < k; j++) {
                    if (order[j] == item) {
                        nextUse = j;
                        break;
                    }
                }
                if (nextUse > farUse) {
                    farUse = nextUse;
                    unplugItem = item;
                }
            }

            plug.remove(unplugItem);
            plug.add(now);
            unplug++;
        }
        System.out.println(unplug);
    }
}
