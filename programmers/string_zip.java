class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i=1;i<=s.length()/2;i++) {
            String start = s.substring(0, i);
            int cnt = 1;
            String result = "";
            for (int j=i;j<=s.length();j+=i) {
                if (s.substring(j,(j+i > s.length() ? s.length() : j+i)).equals(start)) {
                    cnt++;
                }
                else {
                    result += (cnt==1 ? "" : Integer.toString(cnt)) + start;
                    start = s.substring(j,(j+i > s.length() ? s.length() : j+i));
                    cnt = 1;
                }
            }
            result += (cnt==1 ? "" : Integer.toString(cnt)) + start;
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}