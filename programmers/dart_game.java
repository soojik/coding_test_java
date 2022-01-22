class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String tmp = "";
        int arr[] = new int[3];
        int idx = 0;
        char c;
        
        for (int i=0;i<dartResult.length();i++) {
            c = dartResult.charAt(i);
            
            // 옵션
            if (!Character.isLetterOrDigit(c)) {
                if (c == '*') {
                    if (idx > 1) arr[idx-2] *= 2;
                    arr[idx-1] *= 2;
                }
                else if (c == '#'){
                    arr[idx-1] *= (-1);
                }
            }
            // 보너스
            else if (Character.isLetter(c)) {
                arr[idx] = (int)Math.pow(Integer.parseInt(tmp), get_point(c));
                tmp = "";
                idx++;
            }
            // 점수
            else {
                tmp += c;
            }
        }
        
        for (int i=0;i<arr.length;i++)
            answer += arr[i];
        
        return answer;
    }
    
    public int get_point(char c) {
        int result = 0;
        if (c == 'S') result = 1;
        else if (c == 'D') result = 2;
        else if (c == 'T') result = 3;
        
        return result;
    }
}