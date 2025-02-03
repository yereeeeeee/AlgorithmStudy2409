package Silver;

import java.io.*;
import java.util.*;

public class Silver_25757 {
    static Set<String> hasPlayed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Y : 2, F : 3, O : 4
        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        Set<String> hasPlayed = new HashSet<>();
        int players = 0;
        if (type.equals("Y")) {
            players = 2;
        } else if (type.equals("F")) {
            players = 3;
        } else {
            players = 4;
        }
        int cnt = 0;
        int tempPlayers = 1;
        for (int i = 0; i < n; i++) {
            String player = br.readLine();
            if (!hasPlayed.contains(player)) {
                hasPlayed.add(player);
                tempPlayers++;
            }
            if (tempPlayers == players) {
                cnt++;
                tempPlayers = 1;
            }
        }
        System.out.println(cnt);
    }
}
