package gold;
import java.util.*;
import java.io.*;

public class Gold_18223 {
    static class Edge implements Comparable<Edge> {
        int nextV;
        int weight;

        public Edge(int nextV, int weight) {
            this.nextV = nextV;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return nextV + " : " + weight;
        }
    }

    static class Node {
        List<Edge> edges = new ArrayList<>();

        public void addEdge(int v, int w) {
            edges.add(new Edge(v, w));
        }

        public void sortEdges() {
            Collections.sort(edges);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Edge edge : edges) {
                sb.append(edge.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    static int v;
    static int e;
    static int p;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 정점 개수
        e = Integer.parseInt(st.nextToken()); // 간선 개수
        p = Integer.parseInt(st.nextToken()); // 건우 정점
        nodes = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            nodes.add(new Node());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점1
            int b = Integer.parseInt(st.nextToken()); // 정점2
            int c = Integer.parseInt(st.nextToken()); // 거리
            nodes.get(a).addEdge(b, c);
            nodes.get(b).addEdge(a, c);
        }

//        항상 1번 정점에서 P번과 V번 정점으로 갈 수 있는 경로가 존재한다.
        int toV = saveMinJun(1, v);
        int toP = saveMinJun(1, p);
        int pToV = saveMinJun(p, v);
        if (toV >= toP + pToV) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int saveMinJun(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.nextV;
            int curWeight = cur.weight;
            if (curWeight > distance[curNode]) continue;

            for (Edge edge : nodes.get(curNode).edges) {
                int nextNode = edge.nextV;
                int nextWeight = curWeight + edge.weight;
                if (nextWeight < distance[nextNode]) {
                    distance[nextNode] = nextWeight;
                    pq.add(new Edge(nextNode, nextWeight));
                }
            }
        }
        return distance[end];
    }
}
