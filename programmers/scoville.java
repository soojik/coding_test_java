import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        for (int i=0;i<scoville.length;i++) sc.add(scoville[i]);
        
        int tmp = 0;
        while (sc.peek() < K) {
            if (sc.size() == 1) {
                answer = -1;
                break;
            }
            tmp = 0;
            tmp += sc.poll();
            tmp += sc.poll()*2;
            sc.add(tmp);
            answer++;
        }
        
        return answer;
    }
}
