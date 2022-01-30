class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i=3;i<=n;i++)
            answer += (is_prime(i)) ? 1 : 0;
        
        return answer;
    }
    
    public boolean is_prime(int num) {
        boolean result = true;
        
        for (int i=2;i<=Math.sqrt(num);i++) {
            if (num%i == 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}