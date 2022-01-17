class Solution {
    public String solution(String s) {
        String answer = "";
        
        answer = (s.length()%2==0) 
            ? Character.toString(s.charAt(s.length()/2-1)) + Character.toString(s.charAt(s.length()/2)) 
            : Character.toString(s.charAt(s.length()/2));
        
        return answer;
    }
}