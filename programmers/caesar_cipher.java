class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char c;
        int tmp = 0;
        for (int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if (c == ' ') answer += ' ';
            else {
                if ((65 <= (int) c) && ((int) c <= 90)) {
                    tmp = ((int) c + n > 90) ? (int) c + n - 26 : (int) c + n;
                    answer += (char) tmp;
                }
                else {
                    tmp = ((int) c + n > 122) ? (int) c + n - 26 : (int) c + n;
                    answer += (char) tmp;
                }
            }
        }
        
        return answer;
    }
}