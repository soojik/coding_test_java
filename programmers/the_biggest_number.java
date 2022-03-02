import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i=0;i<numbers.length;i++) nums[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        StringBuilder sb = new StringBuilder("");
        
        for (int i=0;i<nums.length;i++) sb.append(nums[i]);
        
        return (sb.charAt(0)=='0') ? "0" : sb.toString();
    }
}
