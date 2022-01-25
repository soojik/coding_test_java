import java.util.*;

class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<Integer>();
        
        answer.add(arr[0]);
        
        for (int i=1;i<arr.length;i++){
            if (arr[i-1] == arr[i])
                continue;
            else
                answer.add(arr[i]);
        }

        return answer;
    }
}