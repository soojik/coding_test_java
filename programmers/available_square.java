class Solution {
    public long solution(long w, long h) {
        long answer = 0;
        
        long GCD = 0;
        for (long i=1;i<=(w>h?h:w);i++)
            if ((w%i==0)&&(h%i==0))
                if (GCD < i) GCD = i;
        
        answer = w*h - (w/GCD + h/GCD - 1)*GCD;
        
        return answer;
    }
}
