class Solution {
    public String solution(int a, int b) {
        int answer = 0;
        
        String[] str = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        for (int i=0;i<a-1;i++) {
            answer += date[i];
        }
        
        answer += b-1;
        
        return str[answer%7];
    }
}