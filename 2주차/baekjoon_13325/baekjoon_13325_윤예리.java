import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n, res;
    static int[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = (int) Math.pow(2, k+1) - 1;
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, 0); // 후위 순회 하면서 모자란 값을 채워서 총 값을 return
        System.out.println(res);
    }

    static int dfs(int idx, int h) {
        if (h==k) {
            // 루트 노드에 도달할 만큼 돌았으면 return
            res += arr[idx];
            return arr[idx];
        }

        int left = dfs(idx*2, h+1);
        int right = dfs(idx*2+1, h+1);
        res += arr[idx] + Math.abs(left-right); // 왼쪽 오른쪽 값의 차랑 현재 값을 더해서 res에 저장
        return arr[idx] + Math.max(left, right); // 왼쪽 오른쪽 중에 큰 값을 쓸 거임 (다 같은 값으로 맞춰야 하니까)
    }
}