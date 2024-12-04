package gold;

import java.util.*;
import java.io.*;

public class Gold_2141 {
    static class Town {
        int pos;
        int people;

        public Town(int pos, int people) {
            this.pos = pos;
            this.people = people;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Town> towns = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            sum += people;
            towns.add(new Town(pos, people));
        }
        towns.sort((o1, o2) -> o1.pos - o2.pos);

        long tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += towns.get(i).people;
            if (Math.ceil((sum + 1) / 2) <= tempSum) {
                System.out.println(towns.get(i).pos);
                return;
            }
        }
    }
}