import java.util.*;

class Solution {
    public boolean bfs(int r, int c, String[] place) {
        boolean result = true;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            
            for (int i=0;i<4;i++) {
                int nr = arr[0] + dr[i];
                int nc = arr[1] + dc[i];
                
                if ((nr < 0) || (nc < 0) || (nc >= 5) || (nr >= 5) || ((nr==r)&&(nc==c)))
                    continue;
                
                int d = Math.abs(nr-r) + Math.abs(nc-c);
                
                if ((d<=2) && place[nr].charAt(nc)=='P') return false;
                else if ((d<2) && place[nr].charAt(nc)=='O') q.add(new int[] {nr, nc});
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i=0;i<places.length;i++) {
            boolean ok = true;
            String[] place = places[i];
            for (int r=0;r<5 && ok;r++) {
                for (int c=0;c<5 && ok;c++) {
                    if ((place[r].charAt(c) == 'P') && !bfs(r,c,place)) ok = false;
                }
            }
            
            answer[i] = (ok) ? 1 : 0;
        }
        
        return answer;
    }
}
