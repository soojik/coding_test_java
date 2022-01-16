import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int n=0;n<commands.length;n++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i=commands[n][0]-1;i<commands[n][1];i++) {
                arr.add(array[i]);
            }
            Collections.sort(arr);
            answer[n] = arr.get(commands[n][2]-1);
        }

        return answer;
    }
}