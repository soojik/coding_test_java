class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String x_ = Integer.toString(x);
        
        int tmp = 0;
        
        for (int i=0;i<x_.length();i++)
            tmp += x_.charAt(i) - '0';    
        
        answer = (x%tmp==0) ? true : false;
        
        return answer;
    }
}
