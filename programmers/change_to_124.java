class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] change_to_124 = {"1", "2", "4"};
        
        int tmp = n;
        if (tmp <= 3) {
            answer = change_to_124[tmp-1];
        }
        else {
            while (tmp >= 1) {
                answer += change_to_124[(tmp-1)%3];
                tmp = (tmp-1)/3;
            }
        }
        
        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        
        return reverse;
    }
}
