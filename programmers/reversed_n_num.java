class Solution {
    public int[] solution(long n) {
        String tmp = Long.toString(n);
        
        int[] answer = new int[tmp.length()];
        
        for (int i=0;i<tmp.length();i++) answer[tmp.length()-i-1] = tmp.charAt(i)-'0';
        
        return answer;
    }
}