class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            int[] tmp = remove_min(arr);
            answer = new int[arr.length-1];
            
            int idx_answer = 0;
            int idx_tmp = 0;
            
            while (idx_answer < answer.length) {
                if (tmp[idx_tmp] > 0) {
                    answer[idx_answer] = tmp[idx_tmp];
                    idx_answer++;
                    idx_tmp++;
                }
                else idx_tmp++;
            }
                
        }
        
        return answer;
    }
    public int[] remove_min(int[] arr) {
        int min = arr[0];
        int idx = 0;
        
        for (int i=1;i<arr.length;i++)
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        
        arr[idx] = -1;
        
        return arr;
    }
}