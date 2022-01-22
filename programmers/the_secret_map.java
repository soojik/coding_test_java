class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0;i<answer.length;i++) answer[i] = "";
        
        String[] arr1_new = new String[n];
        String[] arr2_new = new String[n];
        
        for (int i=0;i<n;i++) {
            arr1_new[i] = Integer.toBinaryString(arr1[i]);
            arr2_new[i] = Integer.toBinaryString(arr2[i]);
        }
        
        String tmp;
        
        for (int i=0;i<n;i++) {
            tmp = "";
            if (arr1_new[i].length() != n) {
                tmp = arr1_new[i];
                arr1_new[i] = "";
                for (int j=0;j<n-tmp.length();j++)
                    arr1_new[i] += "0";
                arr1_new[i] += tmp;
            }
            if (arr2_new[i].length() != n) {
                tmp = arr2_new[i];
                arr2_new[i] = "";
                for (int j=0;j<n-tmp.length();j++)
                    arr2_new[i] += "0";
                arr2_new[i] += tmp;
            }
        }
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if ((arr1_new[i].charAt(j) == '1') || (arr2_new[i].charAt(j) == '1')) {
                    answer[i] += '#';
                } else {
                    answer[i] += ' ';
                }
            }
        }
        
        return answer;
    }
}