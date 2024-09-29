import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        // 0은 루트, 1은 도넛, 2는 막대, 3은 8
        int[] answer = new int[4];
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int node : out.keySet()) {
            if(out.get(node) > 1) {
                // System.out.println(node + " ," + out.get( node));
                if(!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3]++;
                }
            }
        }
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) {
                answer[2]++;
            }
        }
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}