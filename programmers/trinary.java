class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int tmp = 1;
        int cnt = 1;
        while (tmp*3 <= n) {
            tmp *= 3;
            cnt++;
        }
        
        int[] array_3 = new int[cnt];
        int idx = 0;
        while (n != 0) {
            array_3[idx] = n/tmp;
            n -= array_3[idx]*tmp;
            tmp /= 3;
            idx++;
        }
        
        for (int i=0;i<cnt;i++) {
            answer += array_3[i]*Math.pow(3, i);
        }
        
        return answer;
    }
}