class Solution {
    public long solution(long n) {
        long answer = 0;
        
        answer = (Math.sqrt(n)-(int) Math.sqrt(n) == 0) ? (long) Math.pow(Math.sqrt(n)+1, 2) : -1;
        
        return answer;
    }
}