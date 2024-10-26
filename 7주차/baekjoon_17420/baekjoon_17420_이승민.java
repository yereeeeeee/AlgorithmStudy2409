package gold;

import java.io.*;
import java.util.*;

public class Gold_17420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        List<Gifticon> gifticons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long expire = Long.parseLong(st1.nextToken());
            long useDate = Long.parseLong(st2.nextToken());
            gifticons.add(new Gifticon(expire, useDate));
        }

        gifticons.sort(Comparator.comparingLong((Gifticon o) -> o.useDate).thenComparingLong(o -> o.expire));

        long preUseDate = gifticons.get(0).useDate;
        long maxExpire = 0;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            Gifticon cur = gifticons.get(i);

            if (preUseDate > cur.expire) {
                preUseDate = Math.max(preUseDate, cur.useDate);
                // 30으로 나오면 정수가 나와서 가까운 정수하게되면 소수점 이하 다버림
                // 30.0으로 하면 실수 나와서 가까운 정수 하면
                long tempCnt = (long) Math.ceil((preUseDate - cur.expire) / 30.0);
                // 딱 맞아 떨어지면 틀림
//                long tempCnt = (preUseDate - cur.expire) / 30.0 + 1;
                cur.expire += tempCnt * 30;
                cnt += tempCnt;
            }

            maxExpire = Math.max(maxExpire, cur.expire);

            if (1 + i < n && cur.useDate != gifticons.get(i + 1).useDate) {
                preUseDate = maxExpire;
            }
        }
        System.out.println(cnt);
    }

    static class Gifticon {
        long expire;
        long useDate;

        public Gifticon(long expire, long useDate) {
            this.expire = expire;
            this.useDate = useDate;
        }
    }
}

