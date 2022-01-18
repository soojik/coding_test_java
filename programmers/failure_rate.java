class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        double[] failure = new double[N];
        double cnt_challenger;
        double cnt_failure;
        for (int i=1;i<=N;i++) {
            cnt_challenger = 0;
            cnt_failure = 0;
            for (int stage : stages) {
                if (stage >= i) {
                    cnt_challenger++;
                    if (stage == i) {
                        cnt_failure++;
                    }
                }
            }
            failure[i-1] = (cnt_challenger != 0) ? cnt_failure/cnt_challenger : 0;
        }
        
        double max = 1;
        int idx = 0;
        while (idx < N) {
            max = get_max(failure);
            for (int i=0;i<failure.length;i++) {
                if (max == failure[i]) {
                    answer[idx] = i+1;
                    failure[i] = -1;
                    break;
                }
            }
            idx++;
        }
        
        return answer;
    }
    
    public static double get_max(double n[]) {
        double max = n[0];

        for (int i = 1; i < n.length; i++)
            if (n[i] > max) max = n[i];

        return max;
      }
}