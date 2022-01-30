class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        s = s.toLowerCase();
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                answer += ' ';
                idx = 0;
            }
            else {
                answer += (idx%2==0) ? (char)((int)s.charAt(i)-32) : s.charAt(i);
                idx++;
            }
        }
        
        return answer;
    }
}