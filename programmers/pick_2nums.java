import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i=0;i<numbers.length-1;i++) {
            for (int j=i+1;j<numbers.length;j++) {
                if (func(answer, numbers[i]+numbers[j])) {
                    answer.add(numbers[i]+numbers[j]);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    public boolean func(List<Integer> nums, int n) {
        boolean result = true;
        
        for (int i=0;i<nums.size();i++) {
            if (nums.get(i) == n) {
                result = false;
            }
        }
        
        return result;
    }
}