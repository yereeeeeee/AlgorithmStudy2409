import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitSet = 0;

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;

            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    bitSet |= (1 << (x - 1));
                    break;
                case "remove":
                    bitSet &= ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append((bitSet & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitSet ^= (1 << (x - 1));
                    break;
                case "all":
                    bitSet = (1 << 20) - 1;
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
