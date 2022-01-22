import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여유있는 학생이 도난당했을 경우
        for (int i=0;i<lost.length;i++) {
            for (int j=0;j<reserve.length;j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        
        // 앞뒤 번호 확인
        for (int i=0;i<lost.length;i++) {
            if (lost[i] > 0) {
                for (int j=0;j<reserve.length;j++) {
                    if (lost[i]-1 == reserve[j]) {
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    } else if (lost[i]+1 == reserve[j]) {
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
        }
        
        // 체육복 못빌린 학생
        for (int l : lost) {
            if (l > 0) {
                answer++;
            }
        }
        
        return n-answer;
    }
}