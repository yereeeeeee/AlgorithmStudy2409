package Silver;

import java.util.*;

public class Silver_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = n / 3 + n % 3;

        if (res % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}