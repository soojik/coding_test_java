class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long cnt = 0;
        for (int i=1;i<=count;i++) {
            cnt += price*i;
        }
        
        answer = (cnt > money) ? cnt-money : 0;

        return answer;
    }
}