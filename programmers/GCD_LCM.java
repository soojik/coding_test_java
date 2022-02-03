class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {get_GCD(n, m), get_LCM(n, m)};
        
        // int[] answer = {get_GCD(n, m), n*m / get_GCD(n, m)};
        
        return answer;
    }
    
    public int get_GCD(int n, int m) {
        int GCD = 0;
        int min = (n<m) ? n:m;
        
        for (int i=1;i<=min;i++)
            GCD = ((n%i==0) && (m%i==0)) ? i : GCD;
        
        return GCD;
    }
    
    public int get_LCM(int n, int m) {
        int LCM = 0;
        int min = (n>m) ? n:m;
        
        for (int i=min;i<=n*m;i++)
            if ((i%n==0) && (i%m==0)) {
                LCM = i;
                break;
            }
        
        return LCM;
    }
}
