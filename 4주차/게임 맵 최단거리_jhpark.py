from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    di = [1, -1, 0, 0]
    dj = [0, 0, 1, -1]
    
    def bfs():
        visited = [[False] * m for _ in range(n)]
        visited[0][0] = True
        q = deque([[0, 0, 1]])
        while q:
            cur_r, cur_c, new_ans = q.popleft()
            
            if cur_r == n-1 and cur_c == m-1:
                return new_ans
            
            for dij in range(4):
                next_r = cur_r + di[dij]
                next_c = cur_c + dj[dij]
                
                if 0 <= next_r < n and 0 <= next_c < m and not visited[next_r][next_c] and maps[next_r][next_c]:
                    q.append([next_r, next_c, new_ans+1])
                    visited[next_r][next_c] = True
                    
        return -1
    
    answer = bfs()
    return answer