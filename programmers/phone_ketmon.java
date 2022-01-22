class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 중복 삭제
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = -1;
                }
            }
        }
        
        for (int i : nums) {
            if (i > 0) {
                answer++;
            }
        }
        
        answer = (answer>=nums.length/2) ? nums.length/2 : answer;

        return answer;
    }
}