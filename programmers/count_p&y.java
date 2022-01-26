class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        
        int n = 0;
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'p') n++;
            else if (s.charAt(i) == 'y') n--;
        }
        
        answer = (n==0) ? true : false;

        return answer;
    }
}