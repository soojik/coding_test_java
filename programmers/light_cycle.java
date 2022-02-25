import java.util.*;

class Solution {
    int cnt = 0;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][][] visited;
    
    public int dfs(String[] grid, int r, int c, int d) {
        cnt = 0;
        while (true) {
            if (visited[r][c][d]) break;
            
            cnt++;
            visited[r][c][d] = true;
            
            if (grid[r].charAt(c) == 'L') {
                d = (d==3) ? 0 : d+1;
            }
            else if (grid[r].charAt(c) == 'R') {
                d = (d==0) ? 3 : d-1;
            }
            r = (r + dr[d] + grid.length) % grid.length;
            c = (c + dc[d] + grid[0].length()) % grid[0].length();
        }
        return cnt;
    }
    
    public ArrayList<Integer> solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        visited = new boolean[grid.length][grid[0].length()][4];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length();j++)
                for (int d=0;d<4;d++) {
                    if (!visited[i][j][d]) {
                        answer.add(dfs(grid, i, j, d));
                    }
                }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}
