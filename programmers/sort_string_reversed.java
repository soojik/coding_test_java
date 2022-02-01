import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String n_ = Long.toString(n);
        
        Integer[] tmp = new Integer[n_.length()];
        
        for (int i=0;i<tmp.length;i++) tmp[i] = n_.charAt(i) - '0';
        
        Arrays.sort(tmp);
        
        int idx = 0;
        
        while (idx < tmp.length){
            answer += tmp[idx] * Math.pow(10, idx);
            idx++;
        }
        
        return answer;
    }
}