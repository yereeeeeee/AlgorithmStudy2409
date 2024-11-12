package gold;

import java.util.*;
import java.io.*;

public class Gold_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 각 건물의 건설 시간
            int[] buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            // 그래프와 진입 차수 배열 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            int[] indegree = new int[N + 1];

            // 건설 규칙 입력 받기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);
                indegree[Y]++;
            }

            // 목표 건물
            int W = Integer.parseInt(br.readLine());

            // 위상 정렬을 이용한 최소 시간 계산
            sb.append(topologicalSort(N, buildTime, graph, indegree, W)).append("\n");
        }

        System.out.print(sb);
    }

    private static int topologicalSort(int N, int[] buildTime, List<List<Integer>> graph, int[] indegree, int W) {
        int[] resultTime = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        // 초기 세팅 (진입 차수 0인 건물 큐에 추가)
        for (int i = 1; i <= N; i++) {
            resultTime[i] = buildTime[i];
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                // 다음 건물의 최소 건설 시간 갱신
                resultTime[next] = Math.max(resultTime[next], resultTime[current] + buildTime[next]);
                indegree[next]--;

                // 진입 차수가 0이 되면 큐에 추가
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 목표 건물 W의 건설 시간 반환
        return resultTime[W];
    }
}


