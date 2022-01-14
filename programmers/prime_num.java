class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int a=0;a<nums.length-2;a++) {
            for(int b=a+1;b<nums.length-1;b++) {
                for (int c=b+1;c<nums.length;c++) {
                    answer += (is_prime(nums[a]+nums[b]+nums[c])) ? 1 : 0;
                }
            }
        }

        return answer;
    }
    
    public boolean is_prime(int num) {
        boolean result = true;
        
        for (int i=2;i<num;i++) {
            if (num%i == 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}