import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer_array = new ArrayList<>();
        
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(0, 0, 0));
        
        for (int i=0;i<answers.length;i++) {
            i1 = i%5;
            i2 = i%8;
            i3 = i%10;
        
            if (answers[i] == arr1[i1]) {
                tmp.set(0, tmp.get(0)+1);
            } if (answers[i] == arr2[i2]) {
                tmp.set(1, tmp.get(1)+1);
            } if (answers[i] == arr3[i3]) {
                tmp.set(2, tmp.get(2)+1);
            }
        }
        
        int max = Collections.max(tmp);
        
        for (int i=0;i<3;i++) {
            if (tmp.get(i) == max) {
                answer_array.add(i+1);
            }
        }
        
        Collections.sort(answer_array);
        
        int[] answer = new int[answer_array.size()];
        
        for (int i=0;i<answer_array.size();i++) {
            answer[i] = answer_array.get(i);
        }

        return answer;
    }
}