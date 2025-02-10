import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = root;

            for (int j = 0; j < k; j++) {
                String tmp = st.nextToken();
                if (!cur.child.containsKey(tmp)) {
                    cur.child.put(tmp, new Node());
                }

                cur = cur.child.get(tmp);
            }
        }

        print(root, "");
        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        HashMap<String, Node> child;
        public Node() {
            child = new HashMap<>();
        }
    }

    static void print(Node cur, String s) {
        ArrayList<String> list = new ArrayList<>(cur.child.keySet());
        Collections.sort(list);

        for (String str: list) {
            sb.append(s).append(str).append("\n");
            print(cur.child.get(str), s+"--");
        }
    }
}