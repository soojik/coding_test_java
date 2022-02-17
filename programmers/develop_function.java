import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=0;i<progresses.length;i++) {
            q.add((100-progresses[i])/speeds[i] + (((100-progresses[i])%speeds[i]>0) ? 1 : 0));
        }
        
        System.out.println(q);
        int pre_func = q.poll();
        int cnt = 1;
        
        while (q.peek() != null) {
            if (pre_func >= q.peek()) {
                q.poll();
                cnt++;
            }
            else {
                answer.add(cnt);
                cnt = 1;
                pre_func = q.poll();
            }
        }
        
        answer.add(cnt);
        
        return answer;
    }
}
